package derekTutorial;


// Every cat is an animal
// because every method & field in Animals is in the class Cats
public class LessonFourteen {
    public static void main(String[] args) {
        Animals genericAnimal  = new Animals();
        System.out.println(genericAnimal.getName());
        System.out.println(genericAnimal.favFood);

        Cats morris = new Cats("Morris", "Tuna", "Rubber Mouse");

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


        System.out.println(((Cats)randAnimal).favToy);

        if(randAnimal instanceof Cats) {
            System.out.println(randAnimal.getName() +  " is a Cat");
        }

        if(randAnimal instanceof Animals) {
            System.out.println(randAnimal.getName() +  " is an Animal");
        }
    }

}
