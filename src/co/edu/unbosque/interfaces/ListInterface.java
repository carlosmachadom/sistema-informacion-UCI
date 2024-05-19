package co.edu.unbosque.interfaces;

import java.util.List;

/**
 * Esta interfaz define métodos para operaciones básicas de gestión de listas.
 * Los parámetros de tipo genérico <M> y <DTO> representan el tipo de modelo y
 * el tipo de DTO, respectivamente.
 *
 * @param <M>   El tipo de modelo que se maneja en la lista.
 * @param <DTO> El tipo de DTO que se utiliza para agregar y manipular modelos
 *              en la lista.
 */
public interface ListInterface<M, DTO> {
	/**
	 * Agrega un modelo al almacenamiento.
	 *
	 * @param modelDTO El DTO (Data Transfer Object) que representa el modelo a
	 *                 agregar.
	 * @return true si se pudo agregar correctamente, false en caso contrario.
	 */
	boolean add(DTO modelDTO);

	/**
	 * Reemplaza un modelo existente en el almacenamiento.
	 *
	 * @param modelDTO El DTO (Data Transfer Object) que representa el modelo a
	 *                 reemplazar.
	 * @return true si se pudo reemplazar correctamente, false en caso contrario.
	 */
	boolean put(DTO modelDTO);

	/**
	 * Elimina todos los modelos del almacenamiento que coinciden con el DTO
	 * proporcionado.
	 *
	 * @param modelDTO El DTO (Data Transfer Object) que representa los modelos a
	 *                 eliminar.
	 * @return true si se pudo limpiar correctamente, false en caso contrario.
	 */
	boolean clean(DTO modelDTO);

	/**
	 * Obtiene todos los modelos almacenados.
	 *
	 * @return Una lista de modelos almacenados.
	 */
	List<M> all();

	/**
	 * Obtiene un modelo único del almacenamiento basado en el DTO proporcionado.
	 *
	 * @param modelDTO El DTO (Data Transfer Object) que representa el modelo a
	 *                 buscar.
	 * @return El modelo único encontrado, o null si no se encontró ningún modelo.
	 */
	M unique(DTO modelDTO);
}
