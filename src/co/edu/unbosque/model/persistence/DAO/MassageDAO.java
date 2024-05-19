package co.edu.unbosque.model.persistence.DAO;

import co.edu.unbosque.interfaces.DAOInterface;
import co.edu.unbosque.model.persistence.DTO.MassageDTO;
import co.edu.unbosque.model.persistence.FileFactory;
import co.edu.unbosque.model.persistence.adapter.MassageMapHandler;
import co.edu.unbosque.model.therapist.MassageTherapist;

import java.util.List;
/**
 * Clase que implementa la interfaz DAOInterface para realizar operaciones CRUD sobre masajistas.
 */
public class MassageDAO implements DAOInterface<MassageTherapist> {
    /**
     * Manejador para mapear objetos MassageDTO a objetos User y viceversa.
     */
    private final MassageMapHandler massageMapHandler;

    /**
     * Factory para la lectura y escritura del archivo de usuarios.
     */
    private final FileFactory<MassageDTO> fileFactory;

    /**
     * Lista en memoria para almacenar la información de los usuarios leída del archivo.
     */
    private final List<MassageTherapist> massageTherapists;

    /**
     * Constructor para la clase `MassageDAO`.
     */
    public MassageDAO() {
        fileFactory = new FileFactory<>("messages.bin");
        massageMapHandler = new MassageMapHandler();
        massageTherapists = massageMapHandler.transformDTOListToModelList(fileFactory.readFile());
    }

    /**
     * Recupera todos los elementos de la fuente de datos.
     *
     * @return Una lista que contiene todos los elementos almacenados.
     * Si no hay elementos almacenados, se puede retornar una lista vacía.
     */
    @Override
    public List<MassageTherapist> getAllItems() {
        return massageTherapists;
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
    public MassageTherapist findOne(MassageTherapist exist) {
        for (MassageTherapist massageTherapist : getAllItems()) {
            if (massageTherapist.getCC() == exist.getCC()) return massageTherapist;
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
    public boolean CreateItem(MassageTherapist item) {
        if (findOne(item) == null) {
            MassageTherapist newMassage = new MassageTherapist(item.getCC(), item.getExperience(), item.getEmail(), item.getPassword());
            massageTherapists.add(newMassage);

            fileFactory.writeFile(massageMapHandler.transformModelListToDTOList(massageTherapists));
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
    public boolean updateItem(MassageTherapist item) {
        if (findOne(item) != null) {
            MassageTherapist putMessage = findOne(item);
            putMessage.setExperience(item.getExperience());
            putMessage.setPassword(item.getPassword());

            fileFactory.writeFile(massageMapHandler.transformModelListToDTOList(massageTherapists));
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
    public boolean deleteItem(MassageTherapist item) {
        if (findOne(item) != null) {
            MassageTherapist massageDestroy = findOne(item);
            massageTherapists.remove(massageDestroy);

            fileFactory.writeFile(massageMapHandler.transformModelListToDTOList(massageTherapists));
            return true;
        }
        return false;
    }
}
