package co.edu.unbosque.interfaces;

import java.util.List;

/**
 * Esta interfaz define métodos de transformación entre objetos de modelo (M) y objetos de transferencia de datos (DTO).
 * Se utiliza para mapear datos entre diferentes capas de una aplicación.
 *
 * @param <M>   El tipo del objeto modelo.
 * @param <DTO> El tipo del objeto de transferencia de datos.
 */
public interface MapInterface<M, DTO> {
    /**
     * Transforma un objeto DTO en un objeto modelo.
     *
     * @param dto El objeto DTO a transformar.
     * @return El objeto modelo transformado.
     */
    M transformDTOToModel(DTO dto);

    /**
     * Transforma un objeto modelo en un objeto DTO.
     *
     * @param m El objeto modelo a transformar.
     * @return El objeto DTO transformado.
     */
    DTO transformModelToDTO(M m);

    /**
     * Transforma una lista de objetos modelo en una lista de objetos DTO.
     *
     * @param modelList La lista de objetos modelo a transformar.
     * @return La lista de objetos DTO transformados.
     */
    List<DTO> transformModelListToDTOList(List<M> modelList);

    /**
     * Transforma una lista de objetos DTO en una lista de objetos modelo.
     *
     * @param DTOList La lista de objetos DTO a transformar.
     * @return La lista de objetos modelo transformados.
     */
    List<M> transformDTOListToModelList(List<DTO> DTOList);
}