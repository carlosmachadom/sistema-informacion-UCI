package co.edu.unbosque.model.director;

import co.edu.unbosque.interfaces.ListInterface;
import co.edu.unbosque.model.persistence.DAO.DirectorsDAO;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;
import co.edu.unbosque.model.persistence.adapter.DirectorMapHandler;

import java.util.List;

/**
 * Clase que representa una lista de directores y que implementa la interfaz ListInterface para operaciones CRUD.
 */
public class Directors implements ListInterface<Director, DirectorDTO> {
    /**
     * Objeto de Acceso a Datos (DAO) para la persistencia de directores.
     */
    private final DirectorsDAO directorDAO;
    /**
     * Manejador para el mapeo entre objetos DirectorDTO y Director.
     */
    private final DirectorMapHandler directorMapHandler;

    /**
     * Constructor de la clase Directors.
     * Inicializa los objetos DirectorsDAO y DirectorMapHandler.
     */
    public Directors() {
        directorMapHandler = new DirectorMapHandler();
        directorDAO = new DirectorsDAO();
    }

    /**
     * Añade un director a la lista.
     *
     * @param modelDTO El objeto DirectorDTO que se desea añadir.
     * @return true si se añade correctamente, false si no.
     */
    @Override
    public boolean add(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.CreateItem(directorMap);
    }

    /**
     * Actualiza un director en la lista.
     *
     * @param modelDTO El objeto DirectorDTO que se desea actualizar.
     * @return true si se actualiza correctamente, false si no.
     */
    @Override
    public boolean put(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.updateItem(directorMap);
    }

    /**
     * Elimina un director de la lista.
     *
     * @param modelDTO El objeto DirectorDTO que se desea eliminar.
     * @return true si se elimina correctamente, false si no.
     */
    @Override
    public boolean clean(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.deleteItem(directorMap);
    }

    /**
     * Obtiene una lista de todos los directores.
     *
     * @return La lista de directores.
     */
    @Override
    public List<Director> all() {
        return directorDAO.getAllItems();
    }

    /**
     * Obtiene un director único.
     *
     * @param modelDTO El objeto DirectorDTO que se desea obtener.
     * @return El director correspondiente al DTO.
     */
    @Override
    public Director unique(DirectorDTO modelDTO) {
        Director directorMap = directorMapHandler.transformDTOToModel(modelDTO);
        return directorDAO.findOne(directorMap);
    }
}