package designPatterns.builder;

/**
 * Implements a Builder pattern.
 * We can set only the optional parameters we care about. We can do validity checks in build().
 * The instance variables can still be immutable.
 * Example from Effective Java by J. Bloch.
 */
public class NutritionFactsWithBuilder {

    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required

    private final int calories;     //                 optional
    private final int fat;          // (g)             optional
    private final int sodium;       // (mg)            optional
    private final int carbohydrate; // (g)             optional

    private NutritionFactsWithBuilder(Builder builder ) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class Builder {
        private  int servingSize;  // (mL)            required
        private  int servings;     // (per container) required

        private  int calories;     //                 optional
        private  int fat;          // (g)             optional
        private  int sodium;       // (mg)            optional
        private  int carbohydrate; // (g)             optional

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder setSodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder setCarbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFactsWithBuilder build() {
            // validity checks
            if (calories > 0)
                if (fat == 0 && carbohydrate ==0)
                    calories = 0;

            return new NutritionFactsWithBuilder(this);
        }
    }

}
