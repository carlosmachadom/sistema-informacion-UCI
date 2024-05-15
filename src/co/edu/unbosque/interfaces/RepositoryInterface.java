package co.edu.unbosque.interfaces;

/**
 * Esta interfaz define métodos para realizar tareas de repositorio genéricas.
 * <p>
 * El propósito específico de cada método dependerá de la implementación concreta.
 */
public interface RepositoryInterface {
    /**
     * Realiza una precarga de datos desde un archivo u otra fuente de datos.
     * <p>
     * Se espera que este método se ejecute antes de utilizar los datos del repositorio.
     * La implementación específica del método dependerá del tipo de datos y la fuente de la que se cargan.
     */
    void preLoadingFile();

    /**
     * Realiza una verificación del estado del repositorio
     * (por ejemplo, verificar la conexión a la persistencia o la integridad de los archivos).
     * <p>
     * La implementación específica del método dependerá del tipo de repositorio y las
     * comprobaciones que se deseen realizar.
     */
    void helthCheck();
}
