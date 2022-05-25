package derekTutorial;



// Clone means copy current values and everthing of an object at a certain point of time
// if you make changes to one of clone after creating clone
// they are not affect each other
public class LessonSixteen {
    public static void main(String[] args) {
        // every object you ever create inherits all methods of a class
        // Object class -> it is superClass of all classes in hierarchy

        Object superCar = new Vehicle();
        System.out.println(((Vehicle)superCar).getSpeed());

        Vehicle superTruck = new Vehicle();
        System.out.println(superCar.equals(superTruck));

        // each time you create an object java interpreter creates a unique identifier
        // for that and that identifier called as hashCode

        System.out.println(superCar.hashCode());

        // finalise method
        // it is actually a method the java garbage collector calls
        // when you no longer need an object in memory
        // it go and cleans it up get through the extra space in memory
        // we could do it by overselves but there is no point in it


        System.out.println(superCar.getClass());
        System.out.println(superCar.getClass().getName());
        if(superCar.getClass() == superTruck.getClass()) {
            System.out.println("The Same");
        }

        System.out.println(superCar.getClass().getSuperclass());

        Crashable newCars = new Vehicle();
        System.out.println(newCars.toString());

        if(newCars instanceof Crashable) {
            System.out.println("This is Same");
        }

        int randNum = 100;
        System.out.println(Integer.toString(randNum));
        System.out.println(superCar.toString());

        superTruck.setWheels(6);
        Vehicle superTruck2  = (Vehicle)superTruck.clone();
        System.out.println(superTruck2.getClass().getSuperclass().getName());
        System.out.println(superTruck.getWheel());
        System.out.println(superTruck2.getWheel());

        superTruck2.setWheels(10);
        System.out.println();
        System.out.println(superTruck.getWheel());
        System.out.println(superTruck2.getWheel());

        System.out.println();
        System.out.println(superTruck.hashCode());
        System.out.println(superTruck2.hashCode());
    }
}
