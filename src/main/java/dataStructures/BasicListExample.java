package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class BasicListExample {

    public static void main(String[] args) {
        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("China");
        countries.add("Italy");

        for (int i = 0; i < countries.size(); i++) {
            System.out.print(countries.get(i) + " ");
        }

        for (String country: countries) {
            System.out.println(country);
        }
    }
}
