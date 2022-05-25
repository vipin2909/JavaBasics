public class NutritionTesting {
    public static void main(String[] args) {
        NutritionalFacts2 cocaCola = new NutritionalFacts2.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola.getFat());

    }
}
