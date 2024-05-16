package co.edu.unbosque.model.persistence.DAO;

import co.edu.unbosque.helper.Auth;
import co.edu.unbosque.interfaces.DAOInterface;
import co.edu.unbosque.model.User;
import co.edu.unbosque.model.persistence.FileFactory;

import java.util.List;

/**
 * Esta clase implementa la interfaz `DAOInterface` para el acceso a datos de usuarios.
 * Se encarga de la persistencia de objetos `User` en un archivo binario.
 * Utiliza la clase `FileFactory` para la lectura y escritura del archivo, y la clase `Auth` para la autenticación y autorización.
 *
 * @param <User> El tipo de objeto que se persistirá (en este caso, `User`).
 */
public class UsersDAO implements DAOInterface<User> {
    /**
     * Factory para la lectura y escritura del archivo de usuarios.
     */
    private final FileFactory<User> fileFactory;
    /**
     * Lista en memoria para almacenar la información de los usuarios leída del archivo.
     */

    private List<User> users;
    /**
     * Objeto de autenticación y autorización.
     */
    private final Auth auth;

    /**
     * Constructor para la clase `UsersDAO`.
     *
     * @param users Una lista vacía que se llenará con los usuarios leídos del archivo.
     */
    public UsersDAO(List<User> users) {
        fileFactory = new FileFactory<>("users.bin");
        fileFactory.helthCheck();
        auth = new Auth();
        this.users = users;
    }

    /**
     * Recupera todos los usuarios almacenados en el archivo.
     *
     * @return Una lista con todos los objetos `User` leídos del archivo.
     */
    @Override
    public List<User> getAllItems() {
        return fileFactory.readFile();
    }

    /**
     * Busca un usuario específico en la lista en memoria.
     *
     * @param exist El objeto `User` que representa el usuario a buscar (generalmente solo con la CC).
     * @return El objeto `User` encontrado, o null si no se encuentra.
     */
    @Override
    public User findOne(User exist) {
        users = fileFactory.readFile();
        for (User user : users) {
            if (user.getCC() == exist.getCC()) return user;
        }
        return null;
    }

    /**
     * Crea un nuevo usuario y lo agrega al archivo.
     *
     * @param item El objeto `User` que representa el nuevo usuario a crear.
     * @return Verdadero si el usuario se agregó exitosamente, falso si ya existía un usuario con la misma CC.
     */
    @Override
    public boolean CreateItem(User item) {
        if (findOne(item) == null) {
            auth.generateAccessToken(item.getEmail(), item.getPassword());

            User newUser = new User(item.getCC(), item.getExperience(), item.getEmail(), item.getPassword());
            users.add(newUser);

            fileFactory.writeFile(users);
            return true;
        }
        return false;
    }

    /**
     * Actualiza la información de un usuario existente en el archivo.
     *
     * @param item El objeto `User` con los nuevos datos del usuario a actualizar.
     * @return Verdadero si el usuario se actualizó exitosamente, falso si no se encontró el usuario o no hay permisos de autorización.
     */
    @Override
    public boolean updateItem(User item) {
        auth.verifyIsLogged(item.getEmail(), item.getPassword());
        if (findOne(item) != null) {
            auth.verifyAuthorizationUser();
            User putUser = findOne(item);
            putUser.setExperience(item.getExperience());
            putUser.setEmail(item.getEmail());
            putUser.setPassword(item.getPassword());

            fileFactory.writeFile(users);
            return true;
        }
        return false;
    }

    /**
     * Elimina un usuario existente del archivo.
     *
     * @param item El objeto `User` que representa el usuario a eliminar (generalmente solo con la CC).
     * @return Verdadero si el usuario se eliminó exitosamente, falso si no se encontró el usuario o no hay permisos de autorización.
     * @Override Indica que este método implementa el método `deleteItem` de la interfaz `DAOInterface`.
     * Esto obliga a que el método tenga la misma firma (nombre, parámetros y tipo de retorno) que el método de la interfaz.
     */
    @Override
    public boolean deleteItem(User item) {
        auth.verifyIsLogged(item.getEmail(), item.getPassword());
        if (findOne(item) != null) {
            auth.verifyAuthorizationUser();
            User userDestroy = findOne(item);
            users.remove(userDestroy);

            fileFactory.writeFile(users);
            return true;
        }
        return false;
    }
}
