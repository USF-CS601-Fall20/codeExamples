package designPatterns.builder;

/** NutritionFactsWithSetters - contains nutritional info about a food item.
 * Has a constructor for the required parameters. Optional parameters are set using setters.
 * Modified from the example in "Effective Java" by Joshua Bloch.
 * Issues: Cannot make the class immutable.
 *         Object could be left in inconsistent state. How to do validity checks?
 */
public class NutritionFactsWithSetters {
    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required

    private int calories;     //                 optional
    private int fat;          // (g)             optional
    private int sodium;       // (mg)            optional
    private int carbohydrate; // (g)             optional

    public NutritionFactsWithSetters(int servingSize, int servings) {
        this.servingSize = servingSize;
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }


    // Other methods could be added here like getters, toString etc.
}
