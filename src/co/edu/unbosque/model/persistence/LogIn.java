package co.edu.unbosque.model.persistence;

import co.edu.unbosque.util.FileHandler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Esta clase implementa la interfaz `RepositoryInterface` para manejar un token de inicio de sesión.
 * Utiliza un archivo de propiedades ("token.properties") para almacenar y recuperar el token.
 */
public class LogIn {
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
        FileHandler.createFile(file);
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
