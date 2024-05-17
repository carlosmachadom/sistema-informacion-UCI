package co.edu.unbosque.model.persistence.adapter;

import co.edu.unbosque.interfaces.MapInterface;
import co.edu.unbosque.model.Director;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;

import java.util.ArrayList;
import java.util.List;

public class DirectorMapHandler implements MapInterface<Director, DirectorDTO> {
    /**
     * Transforma un objeto DTO en un objeto modelo.
     *
     * @param directorDTO El objeto DTO a transformar.
     * @return El objeto modelo transformado.
     */
    @Override
    public Director transformDTOToModel(DirectorDTO directorDTO) {
        return new Director(directorDTO.getCC(), directorDTO.getExperience(), directorDTO.getEmail(), directorDTO.getPassword(), directorDTO.getNationality());
    }

    /**
     * Transforma un objeto modelo en un objeto DTO.
     *
     * @param director El objeto modelo a transformar.
     * @return El objeto DTO transformado.
     */
    @Override
    public DirectorDTO transformModelToDTO(Director director) {
        DirectorDTO newDTO = new DirectorDTO();
        newDTO.setCC(director.getCC());
        newDTO.setExperience(director.getExperience());
        newDTO.setEmail(director.getEmail());
        newDTO.setPassword(director.getPassword());
        newDTO.setNationality(director.getNationality());
        return newDTO;
    }

    /**
     * Transforma una lista de objetos modelo en una lista de objetos DTO.
     *
     * @param modelList La lista de objetos modelo a transformar.
     * @return La lista de objetos DTO transformados.
     */
    @Override
    public List<DirectorDTO> transformModelListToDTOList(List<Director> modelList) {
        List<DirectorDTO> dtoList = new ArrayList<>();
        for (Director director : modelList) {
            dtoList.add(transformModelToDTO(director));
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
    public List<Director> transformDTOListToModelList(List<DirectorDTO> DTOList) {
        List<Director> directorList = new ArrayList<>();
        for (DirectorDTO directorDTO : DTOList) {
            directorList.add(transformDTOToModel(directorDTO));
        }
        return directorList;
    }
}
