package co.edu.unbosque.model.cyclists;

import co.edu.unbosque.interfaces.ListInterface;
import co.edu.unbosque.model.director.Director;
import co.edu.unbosque.model.persistence.DAO.CyclistsDAO;
import co.edu.unbosque.model.persistence.DTO.CyclistDTO;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;
import co.edu.unbosque.model.persistence.DTO.MassageDTO;
import co.edu.unbosque.model.persistence.adapter.CyclistMapHandler;
import co.edu.unbosque.model.therapist.MassageTherapist;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los ciclistas, implementando las operaciones CRUD.
 */
public class Cyclists implements ListInterface<Cyclist, CyclistDTO> {
    /**
     * Objeto de Acceso a Datos (DAO) para la persistencia de director.
     */
    private final CyclistsDAO cyclistsDAO;
    /**
     * Manejador para el mapeo entre objetos `DirectorDTO` y `Director`.
     */
    private final CyclistMapHandler cyclistMapHandler;

    /**
     * Constructor que inicializa la lista de ciclistas, el DAO y el manejador de mapeo.
     */
    public Cyclists() {
        List<Cyclist> cyclists = new ArrayList<>();
        cyclistsDAO = new CyclistsDAO();
        cyclistMapHandler = new CyclistMapHandler();
    }

    /**
     * Añade un nuevo ciclista a la lista.
     *
     * @param modelDTO el objeto DTO del ciclista a añadir.
     * @return true si el ciclista fue añadido exitosamente, false en caso contrario.
     */
    @Override
    public boolean add(CyclistDTO modelDTO) {
        Cyclist cyclistMap = cyclistMapHandler.transformDTOToModel(modelDTO);
        return cyclistsDAO.CreateItem(cyclistMap);
    }

    /**
     * Actualiza la información de un ciclista existente.
     *
     * @param modelDTO el objeto DTO del ciclista a actualizar.
     * @return true si el ciclista fue actualizado exitosamente, false en caso contrario.
     */
    @Override
    public boolean put(CyclistDTO modelDTO) {
        Cyclist cyclistMap = cyclistMapHandler.transformDTOToModel(modelDTO);
        return cyclistsDAO.updateItem(cyclistMap);
    }

    /**
     * Elimina un ciclista de la lista.
     *
     * @param modelDTO el objeto DTO del ciclista a eliminar.
     * @return true si el ciclista fue eliminado exitosamente, false en caso contrario.
     */
    @Override
    public boolean clean(CyclistDTO modelDTO) {
        Cyclist cyclistMap = cyclistMapHandler.transformDTOToModel(modelDTO);
        return cyclistsDAO.deleteItem(cyclistMap);
    }

    /**
     * Obtiene todos los ciclistas de la lista.
     *
     * @return una lista de todos los ciclistas.
     */
    @Override
    public List<Cyclist> all() {
        return cyclistsDAO.getAllItems();
    }

    /**
     * Busca y obtiene un ciclista único basado en la información del DTO.
     *
     * @param modelDTO el objeto DTO del ciclista a buscar.
     * @return el objeto Cyclist correspondiente, o null si no se encuentra.
     */
    @Override
    public Cyclist unique(CyclistDTO modelDTO) {
        Cyclist cyclistMap = cyclistMapHandler.transformDTOToModel(modelDTO);
        return cyclistsDAO.findOne(cyclistMap);
    }
    
    public CyclistDTO findUser(long user) {
    	Cyclist userFound = cyclistsDAO.findByUserByCC(user);     		
    	
    	if (userFound != null) {
    		
    		CyclistDTO response = cyclistMapHandler.transformModelToDTO(userFound);
    		
    		return response;
    	} else {
    		return null;
    	}    	
    }
    
    public String[][] transformDirectorsDTOListToMatrix() {
    	List<Cyclist> list = cyclistsDAO.getAllItems();
    	
    	if (list != null && list.size() > 0) {
    		List<CyclistDTO> listDTO = cyclistMapHandler.transformModelListToDTOList(list);

    		int columns = 3;
        
	    	String[][] dataMatrix = new String[listDTO.size()][columns];
	
	        for (int i = 0; i < listDTO.size(); i++) {
	        	CyclistDTO user = listDTO.get(i);
	            dataMatrix[i][0] = ""+user.getCC();
	            dataMatrix[i][1] = user.getName();
	            dataMatrix[i][2] = user.getEmail();
	        }
	
	        return dataMatrix;
    	} else {
    		return new String[0][0];
    	}    	
    }
    
    public String[][] transformDirectorDTOToMatrixKeyValue(long cc) {
        Cyclist cyclist = cyclistsDAO.findByUserByCC(cc);
        
        if (cyclist != null) {
            CyclistDTO cyclistDTO = cyclistMapHandler.transformModelToDTO(cyclist);

            int rows = 4;
            int columns = 2;
            
            String[][] dataMatrix = new String[rows][columns];

            int index = 0;

            dataMatrix[index][0] = "Nombre:";
            dataMatrix[index][1] = "" + cyclistDTO.getName();
            index++;

            dataMatrix[index][0] = "Cédula de ciudadanía:";
            dataMatrix[index][1] = "" + cyclistDTO.getCC();
            index++;

            dataMatrix[index][0] = "Correo electrónico:";
            dataMatrix[index][1] = cyclistDTO.getEmail();
            index++;

            dataMatrix[index][0] = "Años de experiencia:";
            dataMatrix[index][1] = "" + cyclistDTO.getExperience();
            index++;

            return dataMatrix;
        } else {
            return new String[0][0];
        }   
    }
}
