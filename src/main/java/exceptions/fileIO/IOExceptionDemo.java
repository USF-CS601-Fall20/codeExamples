package exceptions.fileIO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOExceptionDemo {

    public static void main(String[] args)    {
       try {
            readFromFile(Paths.get("fileThatDoesNotExist.txt"));
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readFromFile(Path path)  throws IOException {
        BufferedReader reader = null;
       // try {
            //int a = 5 / 0; // Uncomment it and see what happens
            reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
      /*  }
        catch(IOException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println("Some general exception occurred." + e);
        }
        finally {
            System.out.println("In finally block");
            // Close the reader
            // Note: we would NOT need to do it if we used try with resources! Would be much better
            try {
                if (reader != null) // important!
                    reader.close();
            }
            catch(IOException e) {
                System.out.println("Cannot close the reader");
            }
        }*/
        System.out.println("After the finally block");
    }
}
