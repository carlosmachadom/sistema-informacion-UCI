package co.edu.unbosque.model.persistence.DAO;

import co.edu.unbosque.helper.Auth;
import co.edu.unbosque.interfaces.DAOInterface;
import co.edu.unbosque.model.Director;
import co.edu.unbosque.model.User;
import co.edu.unbosque.model.persistence.FileFactory;

import java.util.List;

public class DirectorsDAO implements DAOInterface<Director> {
    /**
     * Factory para la lectura y escritura del archivo de directores.
     */
    private final FileFactory<Director> fileFactory;

    /**
     * Lista en memoria para almacenar la información de los directores leída del archivo.
     */
    private List<Director> directors;

    /**
     * Objeto de autenticación y autorización.
     */
    private final Auth auth;

    /**
     * Constructor para la clase `DirectorDAO`.
     *
     * @param directors Una lista vacía que se llenará con los usuarios leídos del archivo.
     */
    public DirectorsDAO(List<Director> directors) {
        fileFactory = new FileFactory<>("directors.bin");
        fileFactory.helthCheck();
        auth = new Auth();
        this.directors = directors;
    }
    /**
     * Recupera todos los elementos de la fuente de datos.
     *
     * @return Una lista que contiene todos los elementos almacenados.
     * Si no hay elementos almacenados, se puede retornar una lista vacía.
     */
    @Override
    public List<Director> getAllItems() {
        return fileFactory.readFile();
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
        directors = fileFactory.readFile();
        for (Director director : directors) {
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
            auth.generateAccessToken(item.getEmail(), item.getPassword());

            Director newDirector = new Director(item.getCC(), item.getExperience(), item.getEmail(), item.getPassword(), item.getNationality());
            directors.add(newDirector);

            fileFactory.writeFile(directors);
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
        auth.verifyIsLogged(item.getEmail(), item.getPassword());
        if (findOne(item) != null) {
            auth.verifyAuthorizationDirector();
            Director putDirector = findOne(item);
            putDirector.setExperience(item.getExperience());
            putDirector.setPassword(item.getPassword());
            putDirector.setNationality(item.getNationality());

            fileFactory.writeFile(directors);
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
        auth.verifyIsLogged(item.getEmail(), item.getPassword());
        if (findOne(item) != null) {
            auth.verifyAuthorizationDirector();
            Director directorDestroy = findOne(item);
            directors.remove(directorDestroy);

            fileFactory.writeFile(directors);
            return true;
        }
        return false;
    }
}
