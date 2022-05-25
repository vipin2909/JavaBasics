import com.sun.security.jgss.GSSUtil;

public class LessonFourteen {
    public static void main(String[] args) {
        Animals genericAnimal = new Animals();
        System.out.println(genericAnimal.getName());
        System.out.println(genericAnimal.favFood);
        Cats morris = new Cats("Morris", "Tuna", "RubberMouse");
        System.out.println("\n");
        System.out.println(morris.getName());
        System.out.println(morris.favFood);
        System.out.println(morris.favToy);
        Animals tabby = new Cats("Tabby", "Salmon", "Ball");
        acceptAnimal(tabby);
    }
    public static void acceptAnimal(Animals randAnimal) {
        System.out.println();
        System.out.println(randAnimal.getName());
        System.out.println(randAnimal.favFood);
        System.out.println();

        randAnimal.walkAround();
//        try {
//            System.out.println(randAnimal.favToy);
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
        // this is called casting into diff object
        // this could be done in another way
        // Cats tempCat = (Cats)randAnimal;
        System.out.println(((Cats)randAnimal).favToy);
        if(randAnimal instanceof  Cats) {
            System.out.println("This is instance of cat class");
        }
    }
}
