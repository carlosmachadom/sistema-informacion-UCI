package co.edu.unbosque.model;

import co.edu.unbosque.interfaces.ListInterface;
import co.edu.unbosque.model.persistence.DAO.UsersDAO;
import co.edu.unbosque.model.persistence.DTO.UserDTO;
import co.edu.unbosque.model.persistence.adapter.UserMapHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase administra los datos de los usuarios dentro de la aplicación.
 * Utiliza un objeto `UsersDAO` para las operaciones de persistencia y un objeto `UserMapHandler` para el mapeo entre objetos `UserDTO` y `User`.
 */
public class Users implements ListInterface<User, UserDTO> {
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
     * @param modelDTO Los datos del usuario a agregar representados como un objeto `UserDTO`.
     * @return Verdadero si el usuario se agregó exitosamente, falso en caso contrario.
     */
    @Override
    public boolean add(UserDTO modelDTO) {
        User userMap = userMapHandler.transformDTOToModel(modelDTO);
        return usersDAO.CreateItem(userMap);
    }

    /**
     * Modificar el User
     *
     * @param modelDTO Los datos del usuario a eliminar representados como un objeto `UserDTO`.
     * @return Verdadero si el usuario se eliminó exitosamente, falso en caso contrario.
     */
    @Override
    public boolean put(UserDTO modelDTO) {
        User userMap = userMapHandler.transformDTOToModel(modelDTO);
        return usersDAO.updateItem(userMap);
    }

    /**
     * El propósito de este método eliminar User.
     *
     * @param modelDTO Los datos del usuario a eliminar representados como un objeto `UserDTO`.
     * @return Verdadero si el usuario se eliminó exitosamente, falso en caso contrario.
     */
    @Override
    public boolean clean(UserDTO modelDTO) {
        User userMap = userMapHandler.transformDTOToModel(modelDTO);
        return usersDAO.deleteItem(userMap);
    }

    /**
     * Recupera todos los usuarios del sistema.
     *
     * @return Una lista de todos los objetos `User` que representan a los usuarios del sistema.
     */
    @Override
    public List<User> all() {
        return usersDAO.getAllItems();
    }

    /**
     * Recupera un usuario específico basado en los datos proporcionados en el objeto `UserDTO`.
     *
     * @param modelDTO Los datos del usuario a buscar representados como un objeto `UserDTO`.
     * @return El objeto `User` que representa al usuario encontrado, o null si no se encuentra.
     */
    @Override
    public User unique(UserDTO modelDTO) {
        User userMap = userMapHandler.transformDTOToModel(modelDTO);
        return usersDAO.findOne(userMap);
    }
}
