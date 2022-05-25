public class LessonSixteen {
    public static void main(String[] args) {
        Object superCar = new Vehicle();
        // casting is important before accessing the methods of derived class
        System.out.println(((Vehicle)superCar).getSpeed());
        Vehicle superTruck = new Vehicle();
//        Vehicle superTruck = new Vehicle();
        System.out.println(superCar.equals(superTruck));
        System.out.println(superCar.hashCode());
        System.out.println(superTruck.hashCode());
        System.out.println(superCar.getClass());
        System.out.println(superCar.getClass().getName());

        if(superCar.getClass() == superTruck.getClass()) {
            System.out.println("The same classes: ");
        }
        System.out.println();
        // these all methods are pre-written in java language
        System.out.println(superCar.getClass().getSuperclass());
        int randNum = 100;
        System.out.println(Integer.toString(randNum));
        System.out.println(superCar.toString());
        superTruck.setWheels(6);
        Vehicle superTruck2 = (Vehicle)superTruck.clone();
        System.out.println(superTruck.getWheel());
        superTruck2.setWheels(23);
        System.out.println(superTruck2.getWheel());
        superTruck.setWheels(234);
        System.out.println(superTruck.getWheel());
        System.out.println(superTruck.hashCode());
        System.out.println(superTruck2.hashCode());
    }
}
