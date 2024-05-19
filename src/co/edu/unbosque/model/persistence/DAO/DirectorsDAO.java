package co.edu.unbosque.model.persistence.DAO;

import co.edu.unbosque.interfaces.DAOInterface;
import co.edu.unbosque.model.director.Director;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;
import co.edu.unbosque.model.persistence.FileFactory;
import co.edu.unbosque.model.persistence.adapter.DirectorMapHandler;

import java.util.List;

public class DirectorsDAO implements DAOInterface<Director> {
    /**
     * Manejador para mapear objetos DirectosDTO a objetos Director y viceversa.
     */
    private final DirectorMapHandler directorMapHandler;

    /**
     * Fábrica de archivos para la persistencia de objetos DirectorDTO.
     */
    private final FileFactory<DirectorDTO> fileFactory;

    /**
     * Lista de usuarios almacenados en la capa de persistencia.
     */
    private final List<Director> directors;

    /**
     * Constructor de la clase DirectorsDAO.
     * Inicializa la fábrica de archivos, el manejador de mapeo y carga la lista de usuarios desde el archivo.
     */
    public DirectorsDAO() {
        fileFactory = new FileFactory<>("directors.bin");
        directorMapHandler = new DirectorMapHandler();
        directors = directorMapHandler.transformDTOListToModelList(fileFactory.readFile());
    }

    /**
     * Recupera todos los elementos de la fuente de datos.
     *
     * @return Una lista que contiene todos los elementos almacenados.
     * Si no hay elementos almacenados, se puede retornar una lista vacía.
     */
    @Override
    public List<Director> getAllItems() {
        return directors;
    }

    /**
     * Busca un elemento específico en la fuente de datos.
     *
     * @param exist El elemento que se desea buscar.
     *              El método compara el elemento proporcionado con los elementos existentes en la fuente de datos
     *              para encontrar una coincidencia.
     * @return El elemento encontrado si se encuentra una coincidencia. Si no se encuentra ninguna coincidencia,
     * se puede retornar `null`.
     */
    @Override
    public Director findOne(Director exist) {
        for (Director director : getAllItems()) {
            if (director.getCC() == exist.getCC()) return director;
        }
        return null;
    }

    /**
     * Crea un nuevo elemento en la fuente de datos.
     *
     * @param item El elemento que se desea crear.
     * @return `true` si la creación del elemento se realiza con éxito. `false` si ocurre un error durante la creación.
     */
    @Override
    public boolean CreateItem(Director item) {
        if (findOne(item) == null) {
            Director newDirector = new Director(item.getCC(), item.getExperience(), item.getEmail(), item.getPassword(), item.getNationality());
            directors.add(newDirector);

            fileFactory.writeFile(directorMapHandler.transformModelListToDTOList(directors));
            return true;
        }
        return false;
    }

    /**
     * Actualiza un elemento existente en la fuente de datos.
     *
     * @param item El elemento actualizado que se desea almacenar.
     * @return `true` si la actualización del elemento se realiza con éxito. `false` si ocurre un error durante la actualización.
     */
    @Override
    public boolean updateItem(Director item) {
        if (findOne(item) != null) {
            Director putDirector = findOne(item);

            putDirector.setExperience(item.getExperience());
            putDirector.setPassword(item.getPassword());
            putDirector.setNationality(item.getNationality());

            fileFactory.writeFile(directorMapHandler.transformModelListToDTOList(directors));
            return true;
        }
        return false;
    }

    /**
     * Elimina un elemento existente en la fuente de datos.
     *
     * @param item El elemento que se desea eliminar.
     * @return `true` si la eliminación del elemento se realiza con éxito. `false` si ocurre un error durante la eliminación.
     */
    @Override
    public boolean deleteItem(Director item) {
        if (findOne(item) != null) {
            Director directorDestroy = findOne(item);
            directors.remove(directorDestroy);

            fileFactory.writeFile(directorMapHandler.transformModelListToDTOList(directors));
            return true;
        }
        return false;
    }
}
