package co.edu.unbosque.model.persistence.DAO;

import co.edu.unbosque.interfaces.DAOInterface;
import co.edu.unbosque.model.persistence.DTO.UserDTO;
import co.edu.unbosque.model.persistence.FileFactory;
import co.edu.unbosque.model.persistence.adapter.UserMapHandler;
import co.edu.unbosque.model.user.User;

import java.util.List;

/**
 * Objeto de Acceso a Datos (DAO) para gestionar usuarios en la capa de persistencia.
 */
public class UsersDAO implements DAOInterface<User> {
    /**
     * Manejador para mapear objetos UserDTO a objetos User y viceversa.
     */
    private final UserMapHandler userMapHandler;

    /**
     * Fábrica de archivos para la persistencia de objetos UserDTO.
     */
    private final FileFactory<UserDTO> fileFactory;

    /**
     * Lista de usuarios almacenados en la capa de persistencia.
     */
    private final List<User> users;

    /**
     * Constructor de la clase UsersDAO.
     * Inicializa la fábrica de archivos, el manejador de mapeo y carga la lista de usuarios desde el archivo.
     */
    public UsersDAO() {
        fileFactory = new FileFactory<>("users.bin");
        userMapHandler = new UserMapHandler();
        users = userMapHandler.transformDTOListToModelList(fileFactory.readFile());
    }

    /**
     * Obtiene todos los usuarios almacenados.
     *
     * @return Lista de todos los usuarios almacenados.
     */
    @Override
    public List<User> getAllItems() {
        return users;
    }

    /**
     * Busca un usuario en la lista por su número de identificación.
     *
     * @param exist Usuario con el número de identificación a buscar.
     * @return El usuario encontrado o null si no se encuentra.
     */
    @Override
    public User findOne(User exist) {
        for (User user : getAllItems()) {
            if ((user.getCC() == exist.getCC())) return user;
        }
        return null;
    }
    
    public User findByUserAndPassword(long u, String pws) {
    	User userFound = null;
    	
    	for (User user : getAllItems()) {
            if ((user.getCC() == u) && (user.getPassword().equals(pws))) { 
            	userFound = user;
            }
        }
        
        return userFound;
    }

    /**
     * Crea un nuevo usuario en la lista y lo guarda en el archivo.
     *
     * @param item Usuario a crear.
     * @return true si se creó correctamente, false si el usuario ya existe.
     */
    @Override
    public boolean CreateItem(User item) {
        if (findOne(item) == null) {
            User newUser = new User(item.getCC(), item.getExperience(), item.getEmail(), item.getPassword());
            users.add(newUser);

            fileFactory.writeFile(userMapHandler.transformModelListToDTOList(users));
            return true;
        }
        return false;
    }

    /**
     * Actualiza la información de un usuario existente en la lista y guarda los cambios en el archivo.
     *
     * @param item Usuario con la información actualizada.
     * @return true si se actualizó correctamente, false si el usuario no existe.
     */
    @Override
    public boolean updateItem(User item) {
        if (findOne(item) != null) {
            User putUser = findOne(item);

            putUser.setExperience(item.getExperience());
            putUser.setPassword(item.getPassword());

            fileFactory.writeFile(userMapHandler.transformModelListToDTOList(users));
            return true;
        }
        return false;
    }

    /**
     * Elimina un usuario de la lista y guarda los cambios en el archivo.
     *
     * @param item Usuario a eliminar.
     * @return true si se eliminó correctamente, false si el usuario no existe.
     */
    @Override
    public boolean deleteItem(User item) {
        if (findOne(item) != null) {
            User userDestroy = findOne(item);
            users.remove(userDestroy);

            fileFactory.writeFile(userMapHandler.transformModelListToDTOList(users));
            return true;
        }
        return false;
    }
}

