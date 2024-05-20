package co.edu.unbosque.model.director;

import co.edu.unbosque.interfaces.ListInterface;
import co.edu.unbosque.model.persistence.DAO.DirectorsDAO;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;
import co.edu.unbosque.model.persistence.DTO.MassageDTO;
import co.edu.unbosque.model.persistence.adapter.DirectorMapHandler;
import co.edu.unbosque.model.therapist.MassageTherapist;

import java.util.List;

/**
 * Clase que gestiona los directores, implementando las operaciones CRUD.
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
     * Constructor que inicializa la lista de directores, el DAO y el manejador de mapeo.
     */
    public Directors() {
        directorMapHandler = new DirectorMapHandler();
        directorDAO = new DirectorsDAO();
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
    
    public DirectorDTO findUser(long user) {
    	Director userFound = directorDAO.findByUserByCC(user);     		
    	
    	if (userFound != null) {
    		
    		DirectorDTO response = directorMapHandler.transformModelToDTO(userFound);
    		
    		return response;
    	} else {
    		return null;
    	}    	
    }
    
    public String[][] transformDirectorsDTOListToMatrix() {
    	List<Director> list = directorDAO.getAllItems();
    	
    	if (list != null && list.size() > 0) {
    		List<DirectorDTO> listDTO = directorMapHandler.transformModelListToDTOList(list);

    		int columns = 3;
        
	    	String[][] dataMatrix = new String[listDTO.size()][columns];
	
	        for (int i = 0; i < listDTO.size(); i++) {
	            DirectorDTO user = listDTO.get(i);
	            dataMatrix[i][0] = ""+user.getCC();
	            dataMatrix[i][1] = user.getNationality();
	            dataMatrix[i][2] = user.getEmail();
	        }
	
	        return dataMatrix;
    	} else {
    		return new String[0][0];
    	}    	
    }
}