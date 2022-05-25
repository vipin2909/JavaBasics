public class EnumExample {
    // defining the enum inside the class
    public enum Seasons { WINTER, SPRING, SUMMER, FALL };
    // main method
    public static void main(String[] args) {
        for(Seasons s: Seasons.values()) {
            System.out.println(s);
        }
    }
}
