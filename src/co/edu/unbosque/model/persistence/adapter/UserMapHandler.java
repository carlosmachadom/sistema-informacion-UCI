package co.edu.unbosque.model.persistence.adapter;

import co.edu.unbosque.interfaces.MapInterface;
import co.edu.unbosque.model.User;
import co.edu.unbosque.model.persistence.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz `MapInterface` para el mapeo entre objetos `User` y `UserDTO`.
 * Se utiliza para transformar objetos de un tipo a otro, facilitando el intercambio de información entre capas de la aplicación.
 *
 * @param <User>    El tipo de objeto del modelo (contiene la lógica de la aplicación).
 * @param <UserDTO> El tipo de objeto de transferencia de datos (DTO, utilizado para transportar información entre capas).
 */
public class UserMapHandler implements MapInterface<User, UserDTO> {

    /**
     * Convierte un objeto `UserDTO` (que contiene datos para transferir) a un objeto `User` del modelo de la aplicación.
     *
     * @param userDTO El objeto `UserDTO` que se desea transformar.
     * @return Un nuevo objeto `User` creado a partir de los datos del `UserDTO`.
     */
    @Override
    public User transformDTOToModel(UserDTO userDTO) {
        return new User(userDTO.getCC(), userDTO.getExperience(), userDTO.getEmail(), userDTO.getPassword());
    }

    /**
     * Convierte un objeto `User` del modelo de la aplicación a un objeto `UserDTO` para transferir datos.
     *
     * @param user El objeto `User` que se desea transformar.
     * @return Un nuevo objeto `UserDTO` creado a partir de los datos del `User`.
     */
    @Override
    public UserDTO transformModelToDTO(User user) {
        UserDTO newDTO = new UserDTO();
        newDTO.setCC(user.getCC());
        newDTO.setExperience(user.getExperience());
        newDTO.setEmail(user.getEmail());
        newDTO.setPassword(user.getPassword());
        return newDTO;
    }

    /**
     * Convierte una lista de objetos `User` del modelo a una lista de objetos `UserDTO` para transferir datos.
     *
     * @param modelList La lista de objetos `User` que se desea transformar.
     * @return Una nueva lista de objetos `UserDTO` creados a partir de la lista original.
     */
    @Override
    public List<UserDTO> transformModelListToDTOList(List<User> modelList) {
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : modelList) {
            usersDTO.add(transformModelToDTO(user));
        }
        return usersDTO;
    }

    /**
     * Convierte una lista de objetos `UserDTO` para transferir datos a una lista de objetos `User` del modelo.
     *
     * @param DTOList La lista de objetos `UserDTO` que se desea transformar.
     * @return Una nueva lista de objetos `User` creados a partir de la lista original.
     */
    @Override
    public List<User> transformDTOListToModelList(List<UserDTO> DTOList) {
        List<User> userList = new ArrayList<>();
        for (UserDTO userDTO : DTOList) {
            userList.add(transformDTOToModel(userDTO));
        }
        return userList;
    }
}
