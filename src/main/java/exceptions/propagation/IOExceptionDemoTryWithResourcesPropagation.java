package exceptions.propagation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOExceptionDemoTryWithResourcesPropagation {

    public static void main(String[] args) {
        try {
            readFromFile(Paths.get("fileThatDoesNotExist.txt"));
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readFromFile(Path path) throws IOException
    {
       BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
       String line = null;
       while ((line = reader.readLine()) != null) {
                System.out.println(line);
       }

       System.out.println("Last statement");
    }
}
