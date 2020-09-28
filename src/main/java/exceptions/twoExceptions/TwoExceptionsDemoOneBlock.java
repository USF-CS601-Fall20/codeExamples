package exceptions.twoExceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TwoExceptionsDemoOneBlock {

    public static void main(String[] args) {

        readFromFile(Paths.get("fileThatDoesNotExist.txt"));
    }

    public static void readFromFile(Path path) {
        BufferedReader reader = null;
        try {
            int a = 5 / 0; // Arithmetic Exception

            reader = Files.newBufferedReader(path, Charset.forName("UTF-8")); // IOException, since the file does not exit
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(ArithmeticException | IOException  e) {
            System.out.println("IO exception");
        }

        // Uncomment the code below; everything will still work as before
        /*catch (Exception e) {
            System.out.println("General exception");
        }*/
        finally {
            // Close the reader
            // Note: we would NOT need to do it if we used try with resources! Would be much better
            try {
                if (reader != null) // important!
                    reader.close();
            }
            catch(IOException e) {
                System.out.println("Cannot close the reader");
            }
        }
        System.out.println("After the finally block");
    }
}
