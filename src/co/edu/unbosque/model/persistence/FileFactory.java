package co.edu.unbosque.model.persistence;

import co.edu.unbosque.interfaces.RepositoryInterface;
import co.edu.unbosque.util.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase genérica proporciona métodos para la persistencia de datos en archivos.
 * Utiliza serialización de objetos para almacenar y recuperar listas de objetos.
 *
 * @param <T> El tipo de objeto que se desea almacenar en el archivo.
 */
public class FileFactory<T> implements RepositoryInterface {
    /**
     * El nombre del archivo utilizado para almacenar la lista de objetos.
     */
    private final String file;
    /**
     * La lista interna que almacena los objetos en memoria. Se utiliza para
     * optimizar el acceso a los datos y la escritura en el archivo.
     */
    private final List<T> items;

    /**
     * Constructor de la clase.
     *
     * @param filename El nombre del archivo que se utilizará para la persistencia.
     */
    public FileFactory(String filename) {
        this.file = filename;
        items = new ArrayList<>();
    }

    /**
     * Implementa el método `preLoadingFile` de la interfaz `RepositoryInterface`.
     * <p>
     * Crea un archivo vacío para la persistencia de datos.
     * Si el archivo ya existe, se sobrescribe con un objeto `null` para indicar que la lista está vacía.
     *
     * @throws IOException Si ocurre una excepción durante la creación o escritura en el archivo.
     */
    @Override
    public void preLoadingFile() {
        String filepath = FileHandler.getFilepath() + file;

        try (FileOutputStream fileOut = new FileOutputStream(filepath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Implementa el método `helthCheck` de la interfaz `RepositoryInterface`.
     * <p>
     * Verifica si el archivo de datos existe. Si no existe, lo crea utilizando `FileHandler.createFile`.
     * Luego, llama a `preLoadingFile` para inicializar el archivo vacío.
     *
     * @throws IOException Si ocurre una excepción durante la creación del archivo o la inicialización.
     */
    @Override
    public void helthCheck() {
        FileHandler.createFile(file);
        preLoadingFile();
    }

    /**
     * Almacena una lista de objetos en el archivo de persistencia.
     *
     * @param itemsToWrite La lista de objetos que se desea escribir en el archivo.
     * @throws IOException Si ocurre una excepción durante la escritura en el archivo.
     */
    public void writeFile(List<T> itemsToWrite) {
        String filepath = FileHandler.getFilepath() + file;

        try (FileOutputStream fileOut = new FileOutputStream(filepath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            for (T item : itemsToWrite) {
                objectOut.writeObject(item);
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Recupera una lista de objetos del archivo de persistencia.
     *
     * @return La lista de objetos leída del archivo, o una lista vacía si el archivo está vacío o
     * hay un error de lectura.
     * @throws IOException            Si ocurre una excepción durante la lectura del archivo.
     * @throws ClassNotFoundException Si la clase del objeto almacenado no se encuentra.
     */
    public List<T> readFile() {
        List<T> itemsRead = new ArrayList<>();
        String filepath = FileHandler.getFilepath() + file;

        try (FileInputStream fileIn = new FileInputStream(filepath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            while (true) {
                try {
                    @SuppressWarnings("unchecked")
                    T item = (T) objectIn.readObject();
                    itemsRead.add(item);
                } catch (EOFException eof) {
                    break;
                } catch (ClassNotFoundException err) {
                    System.out.println(err.getMessage());
                }
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
        return itemsRead;
    }
}
