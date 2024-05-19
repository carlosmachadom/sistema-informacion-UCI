package co.edu.unbosque.model.persistence;

import co.edu.unbosque.util.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileFactory<T> {

    private final String file;


    public FileFactory(String filename) {
        this.file = filename;
        FileHandler.createFile("users.bin");
    }

    public void writeFile(List<T> itemsToWrite) {
        String filepath = FileHandler.getFilepath() + file;

        try (FileOutputStream fileOut = new FileOutputStream(filepath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(itemsToWrite);
        } catch (IOException err) {
            System.out.println("Error al escribir el archivo: " + err.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> readFile() {
        List<T> itemsRead = new ArrayList<>();
        String filepath = FileHandler.getFilepath() + file;
        try (FileInputStream fileIn = new FileInputStream(filepath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            itemsRead = (List<T>) objectIn.readObject();
        } catch (EOFException eof) {
            // aaa
        } catch (IOException | ClassNotFoundException err) {
            System.out.println("Error al leer el archivo: " + err.getMessage());
        }
        return itemsRead;
    }
}