package derekTutorial;

public class GenericsExample {
    public static void main(String[] args) {

        System.out.println("Hello World");
        Printer printer = new Printer(34);
        printer.print();
        System.out.println(printer.hashCode());
//        printer = new Printer(3.67);
        printer.print();
        System.out.println(printer.hashCode());
    }
}
