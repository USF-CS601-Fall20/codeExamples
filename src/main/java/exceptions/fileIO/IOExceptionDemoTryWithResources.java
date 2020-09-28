package exceptions.fileIO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOExceptionDemoTryWithResources {

    public static void main(String[] args) {

        // readFromFile(Paths.get("fileThatDoesNotExist.txt"));

        readAndPrint("src/main/java/exceptions/fileIO/inputFile", "src/main/java/exceptions/fileIO/outputFile");
    }

    public static void readFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }
        // Do not need a finally block. Java will automatically close the BufferedReader since we specified
        // it as a "resource" in parenthesis
        System.out.println("Last statement");
    }

    /** Reads lines from the input file and writes them to the output file
     *
     * @param input input file
     * @param output output file
     */
    public static void readAndPrint(String input, String output) {
        try (FileReader f = new FileReader(input); PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            BufferedReader br = new BufferedReader(f);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("line = " + line);
                writer.println(line.toLowerCase());

            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException occurred" + e);
        }
        // no need to close FileReader, BufferedReader or PrintWriter because
        // we used try with resources -> they will be closed automatically.
    }

}
