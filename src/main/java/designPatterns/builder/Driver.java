package designPatterns.builder;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Driver {
    public static void main(String[] args) {
        //NutritionFacts facts = new NutritionFacts(3, 10, 100, 0, 0, 50);
        //System.out.println(facts);

        NutritionFactsWithBuilder facts  = new NutritionFactsWithBuilder.Builder(2, 10)
                .setSodium(10)
                .setCarbohydrate(100)
                .build();


    }
}
