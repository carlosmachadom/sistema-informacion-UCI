package co.edu.unbosque.model;

import co.edu.unbosque.interfaces.ListInterface;
import co.edu.unbosque.model.persistence.DAO.DirectorsDAO;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;
import co.edu.unbosque.model.persistence.adapter.DirectorMapHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los directores, implementando las operaciones CRUD.
 */
public class Directors implements ListInterface<Director, DirectorDTO> {
    /**
     * Objeto de Acceso a Datos (DAO) para la persistencia de director.
     */
    private final DirectorsDAO directorDAO;
    /**
     * Manejador para el mapeo entre objetos `DirectorDTO` y `Director`.
     */
    private final DirectorMapHandler directorMapHandler;

    /**
     * Constructor que inicializa la lista de directores, el DAO y el manejador de mapeo.
     */
    public Directors() {
        List<Director> directors = new ArrayList<>();
        directorDAO = new DirectorsDAO(directors);
        directorMapHandler = new DirectorMapHandler();
    }

    /**
     * Añade un nuevo director a la lista.
     *
     * @param modelDTO el objeto DTO del director a añadir.
     * @return true si el director fue añadido exitosamente, false en caso contrario.
     */
    @Override
    public boolean add(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.CreateItem(directorMap);
    }

    /**
     * Actualiza la información de un director existente.
     *
     * @param modelDTO el objeto DTO del director a actualizar.
     * @return true si el director fue actualizado exitosamente, false en caso contrario.
     */
    @Override
    public boolean put(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.updateItem(directorMap);
    }

    /**
     * Elimina un director de la lista.
     *
     * @param modelDTO el objeto DTO del director a eliminar.
     * @return true si el director fue eliminado exitosamente, false en caso contrario.
     */
    @Override
    public boolean clean(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.deleteItem(directorMap);
    }

    /**
     * Obtiene todos los directores de la lista.
     *
     * @return una lista de todos los directores.
     */
    @Override
    public List<Director> all() {
        return directorDAO.getAllItems();
    }

    /**
     * Busca y obtiene un director único basado en la información del DTO.
     *
     * @param modelDTO el objeto DTO del director a buscar.
     * @return el objeto Director correspondiente, o null si no se encuentra.
     */
    @Override
    public Director unique(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.findOne(directorMap);
    }
}
