package co.edu.unbosque.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Esta clase de utilidad proporciona métodos para crear y eliminar archivos en el sistema de archivos.
 * <p>
 * La ruta base para los archivos se define en la constante `filepath`.
 */
public class FileHandler {

    /**
     * La ruta base para los archivos que se crean o eliminan. Se define como "src"
     * seguido por el separador de archivos del sistema operativo y luego "database".
     */
    private static final String filepath = "database" + File.separator;

    /**
     * Crea un nuevo archivo en la ruta especificada por el parámetro `file`.
     * <p>
     * El método verifica si el archivo ya existe antes de crearlo. Si el archivo
     * ya existe, no se realiza ninguna acción.
     *
     * @param file El nombre del archivo que se desea crear.
     * @throws IOException Si ocurre una excepción durante la creación del archivo.
     */
    public static void createFile(String file) {
        Path path = Path.of(filepath + file);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    /**
     * Crea un nuevo archivo en la ruta especificada por el parámetro `file`.
     * <p>
     * El método verifica si el archivo ya existe antes de crearlo. Si el archivo
     * ya existe, no se realiza ninguna acción.
     *
     * @param file El nombre del archivo que se desea crear.
     * @throws IOException Si ocurre una excepción durante la creación del archivo.
     */
    public static void deleteFile(String file) {
        Path path = Path.of(filepath + file);
        try {
            Files.delete(path);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Recupera la ruta base utilizada por la clase para crear y eliminar archivos.
     *
     * @return La ruta base definida en la constante `filepath`.
     */

    public static String getFilepath() {
        return filepath;
    }
}
