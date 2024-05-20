package co.edu.unbosque.model.therapist;

import co.edu.unbosque.interfaces.ListInterface;
import co.edu.unbosque.model.director.Director;
import co.edu.unbosque.model.persistence.DAO.MassageDAO;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;
import co.edu.unbosque.model.persistence.DTO.MassageDTO;
import co.edu.unbosque.model.persistence.DTO.UserDTO;
import co.edu.unbosque.model.persistence.adapter.MassageMapHandler;
import co.edu.unbosque.model.user.User;

import java.util.List;

/**
 * Clase que implementa la interfaz ListInterface para manejar operaciones relacionadas con masajistas.
 */
public class MassageTherapists implements ListInterface<MassageTherapist, MassageDTO> {
    /**
     * Objeto DAO para realizar operaciones CRUD sobre masajistas.
     */
    private final MassageDAO massageDAO;
    /**
     * Objeto para el mapeo entre objetos MassageDTO y MassageTherapist.
     */
    private final MassageMapHandler massageMapHandler;

    /**
     * Constructor de la clase MassageTherapists.
     * Inicializa los objetos MassageDAO y MassageMapHandler.
     */
    public MassageTherapists() {
        massageDAO = new MassageDAO();
        massageMapHandler = new MassageMapHandler();
    }

    /**
     * Agrega un nuevo masajista.
     *
     * @param modelDTO El DTO del masajista a agregar.
     * @return true si se agrega correctamente, false si no.
     */
    @Override
    public boolean add(MassageDTO modelDTO) {
        MassageTherapist massageTherapist = massageMapHandler.transformDTOToModel(modelDTO);
        return massageDAO.CreateItem(massageTherapist);
    }

    /**
     * Actualiza un masajista existente.
     *
     * @param modelDTO El DTO del masajista a actualizar.
     * @return true si se actualiza correctamente, false si no.
     */
    @Override
    public boolean put(MassageDTO modelDTO) {
        MassageTherapist massageTherapist = massageMapHandler.transformDTOToModel(modelDTO);
        return massageDAO.updateItem(massageTherapist);
    }

    /**
     * Elimina un masajista existente.
     *
     * @param modelDTO El DTO del masajista a eliminar.
     * @return true si se elimina correctamente, false si no.
     */
    @Override
    public boolean clean(MassageDTO modelDTO) {
        MassageTherapist massageTherapist = massageMapHandler.transformDTOToModel(modelDTO);
        return massageDAO.deleteItem(massageTherapist);
    }

    /**
     * Obtiene una lista de todos los masajistas.
     *
     * @return La lista de todos los masajistas.
     */
    @Override
    public List<MassageTherapist> all() {
        return massageDAO.getAllItems();
    }

    /**
     * Obtiene un masajista único.
     *
     * @param modelDTO El DTO del masajista a obtener.
     * @return El masajista encontrado o null si no existe.
     */
    @Override
    public MassageTherapist unique(MassageDTO modelDTO) {
        MassageTherapist massageTherapist = massageMapHandler.transformDTOToModel(modelDTO);
        return massageDAO.findOne(massageTherapist);
    }
    
    
    public MassageDTO findUser(long user) {
    	MassageTherapist userFound = massageDAO.findByUserByCC(user);     		
    	
    	if (userFound != null) {
    		
    		MassageDTO response = massageMapHandler.transformModelToDTO(userFound);
    		
    		return response;
    	} else {
    		return null;
    	}    	
    }
    
    public String[][] transformDirectorsDTOListToMatrix() {
    	List<MassageTherapist> list = massageDAO.getAllItems();
    	
    	if (list != null && list.size() > 0) {
    		List<MassageDTO> listDTO = massageMapHandler.transformModelListToDTOList(list);

    		int columns = 3;
        
	    	String[][] dataMatrix = new String[listDTO.size()][columns];
	
	        for (int i = 0; i < listDTO.size(); i++) {
	        	MassageDTO user = listDTO.get(i);
	            dataMatrix[i][0] = ""+user.getCC();
	            dataMatrix[i][1] = user.getEmail();
	        }
	
	        return dataMatrix;
    	} else {
    		return new String[0][0];
    	}    	
    }
    
    public String[][] transformDirectorDTOToMatrixKeyValue(long cc) {
    	MassageTherapist therapist = massageDAO.findByUserByCC(cc);
        
        if (therapist != null) {
        	MassageDTO therapistDTO = massageMapHandler.transformModelToDTO(therapist);

            int rows = 4;
            int columns = 2;
            
            String[][] dataMatrix = new String[rows][columns];

            int index = 0;

            dataMatrix[index][0] = "Cédula de ciudadanía:";
            dataMatrix[index][1] = "" + therapistDTO.getCC();
            index++;

            dataMatrix[index][0] = "Años de experiencia:";
            dataMatrix[index][1] = "" + therapistDTO.getExperience();
            index++;

            dataMatrix[index][0] = "Correo electrónico:";
            dataMatrix[index][1] = therapistDTO.getEmail();
            index++;

            return dataMatrix;
        } else {
            return new String[0][0];
        }   
    }
}
