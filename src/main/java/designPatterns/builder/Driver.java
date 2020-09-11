package designPatterns.builder;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Driver {
    public static void main(String[] args) {
        NutritionFacts facts = new NutritionFacts(3, 10, 100, 50, 9, 50);
        System.out.println(facts);


    }
}
