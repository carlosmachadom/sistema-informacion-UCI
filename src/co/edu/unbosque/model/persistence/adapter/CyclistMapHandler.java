package co.edu.unbosque.model.persistence.adapter;

import co.edu.unbosque.interfaces.MapInterface;
import co.edu.unbosque.model.cyclists.Cyclist;
import co.edu.unbosque.model.persistence.DTO.CyclistDTO;

import java.util.ArrayList;
import java.util.List;

public class CyclistMapHandler implements MapInterface<Cyclist, CyclistDTO> {

    /**
     * Transforma un objeto DTO en un objeto modelo.
     *
     * @param cyclistDTO El objeto DTO a transformar.
     * @return El objeto modelo transformado.
     */
    @Override
    public Cyclist transformDTOToModel(CyclistDTO cyclistDTO) {
        return new Cyclist(
                cyclistDTO.getName(),
                cyclistDTO.getBodyStructure(),
                cyclistDTO.getCadencePedaling(),
                cyclistDTO.getCC(),
                cyclistDTO.getExperience(),
                cyclistDTO.getEmail(),
                cyclistDTO.getPassword()) {
            /**
             * Este método es abstracto y debe ser implementado por las clases hijas
             * para definir la especialidad de cada tipo de ciclista.
             */
            @Override
            public void specialty() {

            }
        };
    }

    /**
     * Transforma un objeto modelo en un objeto DTO.
     *
     * @param cyclist El objeto modelo a transformar.
     * @return El objeto DTO transformado.
     */
    @Override
    public CyclistDTO transformModelToDTO(Cyclist cyclist) {
        CyclistDTO newDTO = new CyclistDTO();
        newDTO.setName(cyclist.getName());
        newDTO.setBodyStructure(cyclist.getBodyStructure());
        newDTO.setCadencePedaling(cyclist.getCadencePedaling());
        newDTO.setCC(cyclist.getCC());
        newDTO.setExperience(cyclist.getExperience());
        newDTO.setEmail(cyclist.getEmail());
        newDTO.setPassword(cyclist.getPassword());
        return newDTO;
    }

    /**
     * Transforma una lista de objetos modelo en una lista de objetos DTO.
     *
     * @param modelList La lista de objetos modelo a transformar.
     * @return La lista de objetos DTO transformados.
     */
    @Override
    public List<CyclistDTO> transformModelListToDTOList(List<Cyclist> modelList) {
        List<CyclistDTO> dtoList = new ArrayList<>();
        for (Cyclist cyclist : modelList) {
            dtoList.add(transformModelToDTO(cyclist));
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
    public List<Cyclist> transformDTOListToModelList(List<CyclistDTO> DTOList) {
        List<Cyclist> cyclistList = new ArrayList<>();
        for (CyclistDTO cyclistDTO : DTOList) {
            cyclistList.add(transformDTOToModel(cyclistDTO));
        }
        return cyclistList;
    }
}
