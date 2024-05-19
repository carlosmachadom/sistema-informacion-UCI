package co.edu.unbosque.model.persistence.DAO;

import co.edu.unbosque.helper.Auth;
import co.edu.unbosque.interfaces.DAOInterface;
import co.edu.unbosque.model.cyclists.Cyclist;
import co.edu.unbosque.model.persistence.FileFactory;

import java.util.List;

/**
 * Esta clase implementa la interfaz `DAOInterface` para el acceso a datos de usuarios.
 * Se encarga de la persistencia de objetos `User` en un archivo binario.
 * Utiliza la clase `FileFactory` para la lectura y escritura del archivo, y la clase `Auth` para la autenticación y autorización.
 *
 * @param <Cyclist> El tipo de objeto que se persistirá (en este caso, `Cyclist`).
 */
public class CyclistsDAO implements DAOInterface<Cyclist> {
    /**
     * Factory para la lectura y escritura del archivo de usuarios.
     */
    private final FileFactory<Cyclist> fileFactory;

    /**
     * Lista en memoria para almacenar la información de los usuarios leída del archivo.
     */
    private List<Cyclist> cyclists;
    /**
     * Objeto de autenticación y autorización.
     */
    private final Auth auth;

    /**
     * Constructor para la clase `UsersDAO`.
     *
     * @param cyclists Una lista vacía que se llenará con los usuarios leídos del archivo.
     */
    public CyclistsDAO(List<Cyclist> cyclists) {
        fileFactory = new FileFactory<>("cyclists.bin");
        fileFactory.helthCheck();
        auth = new Auth();
        this.cyclists = cyclists;
    }
    /**
     * Recupera todos los elementos de la fuente de datos.
     *
     * @return Una lista que contiene todos los elementos almacenados.
     * Si no hay elementos almacenados, se puede retornar una lista vacía.
     */
    @Override
    public List<Cyclist> getAllItems() {
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
    public Cyclist findOne(Cyclist exist) {
        cyclists = fileFactory.readFile();
        for (Cyclist cyclist : cyclists) {
            if (cyclist.getCC() == exist.getCC()) return cyclist;
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
    public boolean CreateItem(Cyclist item) {
        if (findOne(item) == null) {
            auth.generateAccessToken(item.getEmail(), item.getPassword());

            Cyclist newCyclist = new Cyclist(item.getName(), item.getBodyStructure(), item.getCadencePedaling(), item.getCC(), item.getExperience(), item.getEmail(), item.getPassword()) {
                @Override
                public void specialty() {

                }
            };
            cyclists.add(newCyclist);

            fileFactory.writeFile(cyclists);
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
    public boolean updateItem(Cyclist item) {
        auth.verifyIsLogged(item.getEmail(), item.getPassword());
        if (findOne(item) != null) {
            auth.verifyAuthorizationDirector();
            Cyclist putCyclist = findOne(item);
            putCyclist.setName(item.getName());
            putCyclist.setBodyStructure(item.getBodyStructure());
            putCyclist.setCadencePedaling(item.getCadencePedaling());
            putCyclist.setExperience(item.getExperience());
            putCyclist.setPassword(item.getPassword());

            fileFactory.writeFile(cyclists);
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
    public boolean deleteItem(Cyclist item) {
        auth.verifyIsLogged(item.getEmail(), item.getPassword());
        if (findOne(item) != null) {
            auth.verifyAuthorizationDirector();
            Cyclist cyclistDestroy = findOne(item);
            cyclists.remove(cyclistDestroy);

            fileFactory.writeFile(cyclists);
            return true;
        }
        return false;
    }
}
