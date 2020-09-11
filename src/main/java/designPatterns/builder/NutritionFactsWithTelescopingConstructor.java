package designPatterns.builder;

/**
 *  NutritionFactsWithTelescopingConstructor - contains nutritional info about a food item.
 *  Has telescoping constructors.
 *  From "Effective Java" by Joshua Bloch.
 *  Issues: May need to pass some parameters we do not want to pass.
 *          The code is verbose and can be hard to read.
 */
public class NutritionFactsWithTelescopingConstructor {
    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required

    private final int calories;     //                 optional
    private final int fat;          // (g)             optional
    private final int sodium;       // (mg)            optional
    private final int carbohydrate; // (g)             optional

    public NutritionFactsWithTelescopingConstructor(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFactsWithTelescopingConstructor(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFactsWithTelescopingConstructor(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFactsWithTelescopingConstructor(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, sodium, fat, 0);
    }

    public NutritionFactsWithTelescopingConstructor(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    // Other methods as needed


}
