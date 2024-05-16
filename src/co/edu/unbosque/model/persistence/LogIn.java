package co.edu.unbosque.model.persistence;

import co.edu.unbosque.interfaces.RepositoryInterface;
import co.edu.unbosque.util.FileHandler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Esta clase implementa la interfaz `RepositoryInterface` para manejar un token de inicio de sesión.
 * Utiliza un archivo de propiedades ("token.properties") para almacenar y recuperar el token.
 */
public class LogIn implements RepositoryInterface {
    /**
     * El nombre del archivo de propiedades utilizado para almacenar el token ("token.properties").
     */
    private final String file = "token.properties";

    /**
     * Objeto `Properties` utilizado para leer y escribir el token del archivo.
     */
    private final Properties properties;

    /**
     * Constructor sin argumentos que inicializa el objeto `Properties`.
     */
    public LogIn() {
        properties = new Properties();
    }

    /**
     * Implementa el método `preLoadingFile` de la interfaz `RepositoryInterface`.
     * <p>
     * Crea un archivo de propiedades vacío con la propiedad "token" inicializada a "null".
     * Si el archivo ya existe, se sobrescribe con el valor predeterminado.
     *
     * @throws IOException Si ocurre una excepción durante la creación o escritura del archivo de propiedades.
     */
    @Override
    public void preLoadingFile() {
        properties.setProperty("token", "null");
        String path = FileHandler.getFilepath() + file;

        try (FileWriter write = new FileWriter(path)) {
            properties.store(write, "");
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Implementa el método `helthCheck` de la interfaz `RepositoryInterface`.
     * <p>
     * Verifica si el archivo de token existe. Si no existe, lo crea utilizando `FileHandler.createFile`.
     * Luego, llama a `preLoadingFile` para inicializar el archivo con el valor predeterminado del token.
     *
     * @throws IOException Si ocurre una excepción durante la creación del archivo o la inicialización del token.
     */
    @Override
    public void helthCheck() {
        FileHandler.createFile(file);
        preLoadingFile();
    }

    /**
     * Almacena un nuevo token de inicio de sesión en el archivo de propiedades.
     *
     * @param token El token de inicio de sesión que se desea almacenar.
     * @throws IOException Si ocurre una excepción durante la escritura del token en el archivo.
     */
    public void writeFile(String token) {
        String path = FileHandler.getFilepath() + file;

        properties.setProperty("token", token);

        try (FileWriter writer = new FileWriter(path)) {
            properties.store(writer, "");
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Recupera el token de inicio de sesión almacenado en el archivo de propiedades.
     *
     * @return El token de inicio de sesión almacenado, o `null` si no se encuentra el token o hay un error de lectura.
     * @throws IOException Si ocurre una excepción durante la lectura del token del archivo.
     */
    public String readFile() {
        String path = FileHandler.getFilepath() + file;

        try (FileReader reader = new FileReader(path)) {
            properties.load(reader);
            return properties.getProperty("token");
        } catch (IOException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

    /**
     * Obtiene la ruta o el nombre del archivo asociado al objeto.
     *
     * @return La ruta o el nombre del archivo como una cadena de texto.
     */
    public String getFile() {
        return file;
    }
}
