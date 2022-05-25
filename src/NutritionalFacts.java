// Telescoping constructor pattern does not scale well

public class NutritionalFacts {
    private final int servingSize; // (mL) required
    private final int servings; // (per container) required
    private final int calories; // (per serving) optional
    private final int fat; // (g/serving) optional
    private final int sodium = 20; // (mg/serving) optional
    private final int carbohydrate = 40; // (g/serving) optional
    
    public NutritionalFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }
    public NutritionalFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 900);
    }
    public NutritionalFacts(int servingSize, int servings, int calories, int fat) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
    }
//    public NutritionalFacts(int servingSize, int servings, int calories, int fat) {
//        this(servingSize, servings, calories, fat, 0);
//    }
//    public NutritionalFacts(int servingSize, int servings, int calories, int fat, int sodium) {
//        this(servingSize, servings, calories, fat, sodium, 0);
//    }
//
//    public NutritionalFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fat = fat;
//        this.sodium = sodium;
//        this.carbohydrate = carbohydrate;
//    }

    public int getFat() {
//        return this.fat;
        return this.fat;
    }




}

