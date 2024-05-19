package co.edu.unbosque.model.persistence;

import co.edu.unbosque.util.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for reading from and writing to a file.
 *
 * @param <T> The type of object to be stored in the file.
 */
public class FileFactory<T> {
    /**
     * Nombre de archivo
     */
    private final String file;

    /**
     * Constructs a FileFactory object with the specified filename.
     *
     * @param filename The name of the file to be managed.
     */
    public FileFactory(String filename) {
        this.file = filename;
        FileHandler.createFile(file);
    }

    /**
     * Writes a list of items to the file.
     *
     * @param itemsToWrite The list of items to be written to the file.
     */
    public void writeFile(List<T> itemsToWrite) {
        String filepath = FileHandler.getFilepath() + file;

        try (FileOutputStream fileOut = new FileOutputStream(filepath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(itemsToWrite);
        } catch (IOException err) {
            System.out.println("Error al escribir el archivo: " + err.getMessage());
        }
    }

    /**
     * Reads the contents of the file and returns them as a list of items.
     *
     * @return A list containing the items read from the file.
     */
    @SuppressWarnings("unchecked")
    public List<T> readFile() {
        List<T> itemsRead = new ArrayList<>();
        String filepath = FileHandler.getFilepath() + file;
        try (FileInputStream fileIn = new FileInputStream(filepath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            itemsRead = (List<T>) objectIn.readObject();
        } catch (EOFException eof) {
            // End of file reached
        } catch (IOException | ClassNotFoundException err) {
            System.out.println("Error al leer el archivo: " + err.getMessage());
        }
        return itemsRead;
    }
}
