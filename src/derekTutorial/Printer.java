package derekTutorial;

public class Printer<T> {
    T thingsToPrint;
    public Printer(T thingsToPrint) {
        this.thingsToPrint = thingsToPrint;
    }
    public void print() {
        System.out.println("thingsToPrint has an value of " + thingsToPrint + " and have type of " + thingsToPrint.getClass());
    }
}