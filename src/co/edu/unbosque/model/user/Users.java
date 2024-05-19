package co.edu.unbosque.model.user;

import co.edu.unbosque.interfaces.ListInterface;
import co.edu.unbosque.model.persistence.DAO.UsersDAO;
import co.edu.unbosque.model.persistence.DTO.UserDTO;
import co.edu.unbosque.model.persistence.adapter.UserMapHandler;

import java.util.List;

/**
 * Represents a collection of users.
 * This class implements the ListInterface interface for managing user objects.
 */
public class Users implements ListInterface<User, UserDTO> {

    /**
     * Objeto de Acceso a Datos para gestionar usuarios en la capa de persistencia.
     */
    private final UsersDAO usersDAO;

    /**
     * Manejador para mapear objetos UserDTO a objetos User y viceversa.
     */
    private final UserMapHandler userMapHandler;

    /**
     * Constructor for the Users class.
     * Initializes the UsersDAO and UserMapHandler objects.
     */
    public Users() {
        userMapHandler = new UserMapHandler();
        usersDAO = new UsersDAO();
    }

    /**
     * Adds a user to the collection.
     *
     * @param modelDTO The DTO (Data Transfer Object) representing the user to add.
     * @return True if the user was successfully added, false otherwise.
     */
    @Override
    public boolean add(UserDTO modelDTO) {
        User userMap = userMapHandler.transformDTOToModel(modelDTO);
        return usersDAO.CreateItem(userMap);
    }

    /**
     * Updates a user in the collection.
     *
     * @param modelDTO The DTO representing the user to update.
     * @return True if the user was successfully updated, false otherwise.
     */
    @Override
    public boolean put(UserDTO modelDTO) {
        User userMap = userMapHandler.transformDTOToModel(modelDTO);
        return usersDAO.updateItem(userMap);
    }

    /**
     * Deletes a user from the collection.
     *
     * @param modelDTO The DTO representing the user to delete.
     * @return True if the user was successfully deleted, false otherwise.
     */
    @Override
    public boolean clean(UserDTO modelDTO) {
        User userMap = userMapHandler.transformDTOToModel(modelDTO);
        return usersDAO.deleteItem(userMap);
    }

    /**
     * Retrieves all users from the collection.
     *
     * @return A list containing all users in the collection.
     */
    @Override
    public List<User> all() {
        return usersDAO.getAllItems();
    }

    /**
     * Retrieves a unique user from the collection based on the provided DTO.
     *
     * @param modelDTO The DTO representing the user to retrieve.
     * @return The user object if found, null otherwise.
     */
    @Override
    public User unique(UserDTO modelDTO) {
        User userMap = userMapHandler.transformDTOToModel(modelDTO);
        return usersDAO.findOne(userMap);
    }
}
