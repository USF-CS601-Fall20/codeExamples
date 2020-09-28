package jsonFiles;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** The example demonstrates reading from a JSON file */
public class JsonProcessing {
    public static void main(String[] args) {
        JsonProcessing jp = new JsonProcessing();
        jp.jsonParserExample("src/main/java/jsonFiles/people.json");
        // jp.parseSimple("src/main/java/jsonFiles/exJsonSimple.json");
         // jp.parsePersonInfo("src/main/java/jsonFiles/exJsonPersonInfo.json");
        //jp.parsePeople("src/main/java/jsonFiles/exJsonPeople.json");
        //jp.parseJSONObjectWithArray("src/main/java/jsonFiles/exJsonWithArray.json");
    }

    public void jsonParserExample(String filePath) {
        Gson gson = new Gson();
        try {
            String fileData = new String(Files.readAllBytes(Paths.get(filePath)));
            JsonParser parser = new JsonParser();
            JsonObject wholeJsonObject = (JsonObject) parser.parse(fileData);
            JsonObject data = (JsonObject)wholeJsonObject.get("data"); // can use getAsJsonObject method
            JsonArray jsonArr = (JsonArray)data.get("people"); //  to avoid downcasting, you can use getAsJsonArray method
            for (JsonElement element : jsonArr) {
                JsonObject personObj = (JsonObject)element;
                Person p = gson.fromJson(personObj, Person.class);
                System.out.println(p);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    /** This method demonstrates how to parse a simple json file
     * that contains info about fruits; using GSON library.
     *
     * @param filePath path to the json file
     */
    public void parseSimple(String filePath) {
        Gson gson = new Gson();

        try (FileReader br = new FileReader(filePath))  {
            Fruit fruit = gson.fromJson(br, Fruit.class);
            System.out.println(fruit);
        }
        catch(IOException e) {
            System.out.println("Could not read the file:" + e);
        }

    }

    /** This method demonstrates how to parse a json file
     * that contains info about the person using GSON library.
     * Person has an address that is also a Json object
     *
     * @param filePath path to the json file
     */
    public void parsePersonInfo(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // if we want to deserialize and want it to look good

        try (FileReader br = new FileReader(filePath))  {
            Person p = gson.fromJson(br, Person.class);
            System.out.println(p);

            String jsonInString = gson.toJson(p);
            System.out.println(jsonInString);
        }
        catch(IOException e) {
            System.out.println("Could not read the file: " + e);
        }

    }

    /** This method demonstrates how to parse a json file
     * that contains info about several people (value stored in a JSON Array).
     * Uses GSON library.
     *
     * @param filePath path to the json file
     */
    public void parsePeople(String filePath) {
        Gson gson = new Gson();

        try (FileReader br = new FileReader(filePath))  {
            // One way of reading json
            //People people = gson.fromJson(br, People.class);

            // Another way of reading json
            String fileData = new String(Files.readAllBytes(Paths.get(filePath)));
            JsonParser parser = new JsonParser();
            JsonObject jo = (JsonObject)parser.parse(fileData);


            JsonArray jsonArr = jo.getAsJsonArray("people");


            // The commented code is if we want to use an ArrayList instead of array of Person-s
            //Type peopleType = new TypeToken<ArrayList<Person>>(){}.getType();
            //ArrayList<Person> people = gson.fromJson(jsonArr, peopleType);
            Person[] people = gson.fromJson(jsonArr, Person[].class);
            for (Person p: people) {
                System.out.println(p);
            }

        }
        catch(IOException e) {
            System.out.println("Could not read the file: " + e);
        }

    }

    /** Demonstrates yet another way of reading json files using GSON library
     * Here we read each JSON token one by one.
     * @param filePath path to the file
     */
    public void parse(String filePath) {
        try (JsonReader jsonReader = new JsonReader(new FileReader(filePath))) {
            jsonReader.beginObject();

            while (jsonReader.hasNext()) {

                String name = jsonReader.nextName();
                if (name.equals("name")) {
                    String nameOfFruit = jsonReader.nextString();
                    System.out.println(nameOfFruit);
                }
                else if (name.equals("price")){
                    System.out.println(jsonReader.nextLong());
                }
                else if (name.equals("color")) {
                    System.out.println(jsonReader.nextString());
                }
                else if (name.equals("organic")) {
                    System.out.println(jsonReader.nextBoolean());
                }
            }

            jsonReader.endObject();

        } catch (IOException e) {
            System.out.println("Could not read from file");
        }
    }

    /** Shows a way to read a JSON that contains a JSON array
     * a
     * @param filePath
     */
    public void parseJSONObjectWithArray(String filePath) {
        try (JsonReader jsonReader = new JsonReader(new FileReader(filePath))) {
            jsonReader.beginObject();

            List<Fruit> fruits = new ArrayList<Fruit>();

            if (jsonReader.hasNext()) {

                String name = jsonReader.nextName();
                if (name.equals("fruits")) {
                    // Read Json Array
                    jsonReader.beginArray();
                    String nameOfFruit = "";
                    double price = 0;
                    String color = "";
                    boolean isOrganic = true;

                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String name1 = jsonReader.nextName();
                            if (name1.equals("name")) {
                                nameOfFruit = jsonReader.nextString();
                                System.out.print(nameOfFruit + ", ");
                            } else if (name1.equals("price")) {
                                price = jsonReader.nextDouble();
                                System.out.print(price + ", ");
                            } else if (name1.equals("color")) {
                                color = jsonReader.nextString();
                                System.out.print(color + ", ");
                            } else if (name1.equals("organic")) {
                                isOrganic = jsonReader.nextBoolean();
                                System.out.println(isOrganic);
                            }
                        }

                        Fruit f = new Fruit(nameOfFruit, color, price, isOrganic);
                        fruits.add(f);
                        jsonReader.endObject();

                    }
                    jsonReader.endArray();

                }

            }
            jsonReader.endObject();
        }
        catch (IOException e) {
            System.out.println("Could not read from file: " + e);
        }
    }
}
