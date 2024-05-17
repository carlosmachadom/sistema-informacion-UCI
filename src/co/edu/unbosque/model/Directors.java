package co.edu.unbosque.model;

import co.edu.unbosque.interfaces.ListInterface;
import co.edu.unbosque.model.persistence.DAO.DirectorsDAO;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;
import co.edu.unbosque.model.persistence.adapter.DirectorMapHandler;

import java.util.ArrayList;
import java.util.List;

public class Directors implements ListInterface<Director, DirectorDTO> {
    /**
     * Objeto de Acceso a Datos (DAO) para la persistencia de director.
     */
    private DirectorsDAO directorDAO;
    /**
     * Manejador para el mapeo entre objetos `DirectorDTO` y `Director`.
     */
    private DirectorMapHandler directorMapHandler;

    public Directors() {
        List<Director> directors = new ArrayList<>();
        directorDAO = new DirectorsDAO(directors);
        directorMapHandler = new DirectorMapHandler();
    }

    /**
     * @param modelDTO
     * @return
     */
    @Override
    public boolean add(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.CreateItem(directorMap);
    }

    /**
     * @param modelDTO
     * @return
     */
    @Override
    public boolean put(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.updateItem(directorMap);
    }

    /**
     * @param modelDTO
     * @return
     */
    @Override
    public boolean clean(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.deleteItem(directorMap);
    }

    /**
     * @return
     */
    @Override
    public List<Director> all() {
        return directorDAO.getAllItems();
    }

    /**
     * @param modelDTO
     * @return
     */
    @Override
    public Director unique(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.findOne(directorMap);
    }
}
