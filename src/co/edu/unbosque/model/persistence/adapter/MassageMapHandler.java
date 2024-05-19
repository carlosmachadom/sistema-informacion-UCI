package co.edu.unbosque.model.persistence.adapter;

import co.edu.unbosque.interfaces.MapInterface;
import co.edu.unbosque.model.persistence.DTO.MassageDTO;
import co.edu.unbosque.model.therapist.MassageTherapist;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz `MapInterface` para el mapeo entre objetos `User` y `UserDTO`.
 * Se utiliza para transformar objetos de un tipo a otro, facilitando el intercambio de información entre capas de la aplicación.
 *
 * @param <MassageTherapist> El tipo de objeto del modelo (contiene la lógica de la aplicación).
 * @param <MassageDTO> El tipo de objeto de transferencia de datos (DTO, utilizado para transportar información entre capas).
 */
public class MassageMapHandler implements MapInterface<MassageTherapist, MassageDTO> {
    /**
     * Transforma un objeto DTO en un objeto modelo.
     *
     * @param massageDTO El objeto DTO a transformar.
     * @return El objeto modelo transformado.
     */
    @Override
    public MassageTherapist transformDTOToModel(MassageDTO massageDTO) {
        return new MassageTherapist(massageDTO.getCC(), massageDTO.getExperience(), massageDTO.getEmail(), massageDTO.getPassword());
    }

    /**
     * Transforma un objeto modelo en un objeto DTO.
     *
     * @param massageTherapist El objeto modelo a transformar.
     * @return El objeto DTO transformado.
     */
    @Override
    public MassageDTO transformModelToDTO(MassageTherapist massageTherapist) {
        MassageDTO massageDTO = new MassageDTO();
        massageDTO.setCC(massageTherapist.getCC());
        massageDTO.setExperience(massageTherapist.getExperience());
        massageDTO.setEmail(massageTherapist.getEmail());
        massageDTO.setPassword(massageTherapist.getPassword());
        return massageDTO;
    }

    /**
     * Transforma una lista de objetos modelo en una lista de objetos DTO.
     *
     * @param modelList La lista de objetos modelo a transformar.
     * @return La lista de objetos DTO transformados.
     */
    @Override
    public List<MassageDTO> transformModelListToDTOList(List<MassageTherapist> modelList) {
        List<MassageDTO> dtoList = new ArrayList<>();
        for (MassageTherapist massageDTO : modelList) {
            dtoList.add(transformModelToDTO(massageDTO));
        }
        return dtoList;
    }

    /**
     * Transforma una lista de objetos DTO en una lista de objetos modelo.
     *
     * @param DTOList La lista de objetos DTO a transformar.
     * @return La lista de objetos modelo transformados.
     */
    @Override
    public List<MassageTherapist> transformDTOListToModelList(List<MassageDTO> DTOList) {
        List<MassageTherapist> massageTherapists = new ArrayList<>();
        for (MassageDTO massageDTO : DTOList) {
            massageTherapists.add(transformDTOToModel(massageDTO));
        }
        return massageTherapists;
    }
}
