package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.DAO.UsersDAO;
import co.edu.unbosque.model.persistence.DTO.UserDTO;
import co.edu.unbosque.model.persistence.adapter.UserMapHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase administra los datos de los usuarios dentro de la aplicación.
 * Utiliza un objeto `UsersDAO` para las operaciones de persistencia y un objeto `UserMapHandler` para el mapeo entre objetos `UserDTO` y `User`.
 */
public class Users {
    /**
     * Objeto de Acceso a Datos (DAO) para la persistencia de usuarios.
     */
    private final UsersDAO usersDAO;
    /**
     * Manejador para el mapeo entre objetos `UserDTO` y `User`.
     */
    private final UserMapHandler userMapHandler;

    /**
     * Constructor para la clase `Users`.
     * Inicializa el `usersDAO` con una lista vacía y el `userMapHandler`.
     */
    public Users() {
        List<User> users = new ArrayList<>();
        usersDAO = new UsersDAO(users);
        userMapHandler = new UserMapHandler();
    }

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param newUser Los datos del usuario a agregar representados como un objeto `UserDTO`.
     * @return Verdadero si el usuario se agregó exitosamente, falso en caso contrario.
     */
    public boolean addUser(UserDTO newUser) {
        User userMap = userMapHandler.transformDTOToModel(newUser);
        return usersDAO.CreateItem(userMap);
    }

    /**
     * Este método parece ser funcionalmente idéntico a `addUser`.
     * Considere renombrarlo a `updateUser` si actualiza usuarios existentes o aclarar su propósito en la documentación.
     *
     * @param newUser Los datos del usuario a actualizar representados como un objeto `UserDTO`.
     * @return Verdadero si el usuario se actualizó exitosamente (o se agregó si no existía), falso en caso contrario.
     */
    public boolean putUser(UserDTO newUser) {
        User userMap = userMapHandler.transformDTOToModel(newUser);
        return usersDAO.CreateItem(userMap);
    }

    /**
     * El propósito de este método (`cleanUser`) no está claro basado en el nombre.
     * Considere renombrarlo a algo más descriptivo (por ejemplo, `deleteUser`) y actualizar el Javadoc para reflejar su funcionalidad.
     *
     * @param newUser Los datos del usuario a eliminar representados como un objeto `UserDTO`.
     * @return Verdadero si el usuario se eliminó exitosamente, falso en caso contrario.
     */
    public boolean cleanUser(UserDTO newUser) {
        User userMap = userMapHandler.transformDTOToModel(newUser);
        return usersDAO.CreateItem(userMap);
    }

    /**
     * Recupera todos los usuarios del sistema.
     *
     * @return Una lista de todos los objetos `User` que representan a los usuarios del sistema.
     */
    public List<User> getUsers() {
        return usersDAO.getAllItems();
    }

    /**
     * Recupera un usuario específico basado en los datos proporcionados en el objeto `UserDTO`.
     *
     * @param newUser Los datos del usuario a buscar representados como un objeto `UserDTO`.
     * @return El objeto `User` que representa al usuario encontrado, o null si no se encuentra.
     */
    public User getUser(UserDTO newUser) {
        User userMap = userMapHandler.transformDTOToModel(newUser);
        return usersDAO.findOne(userMap);
    }
}
