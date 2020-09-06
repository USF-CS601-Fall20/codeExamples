package fileProcessing;

import java.io.IOException;
import java.nio.file.*;


/** Demonstrates how to use DirectoryStream to get all files and subdirectories
 *  in a given directory */
public class DirectoryStreamExample {

    /** Prints the names of all files in a given directory (on the top level,
     * without going into subdirectories
     * @param directory directory where the method searches for files
     */
    public static void processFiles(String directory) {
        Path p = Paths.get(directory);
        try (DirectoryStream<Path> filesList = Files.newDirectoryStream(p)) {
            for (Path file : filesList) {
                // print the name of each file in the directory
                if (!Files.isDirectory(file))
                    System.out.println(file);
            }
        } catch (IOException e) {
            System.out.println("Can not open directory: " + directory);
        }
    }

    public static void main(String[] args) {
       DirectoryStreamExample.processFiles("src/main/java/javaBasics");

    }
}
