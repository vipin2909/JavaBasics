package cleanCode;

/**
 * A class name should not be a verb like Manager, Processor, Data or Info
 * it could be noun or noun phrases names like Customer, WikiPage, Accound and Address
 * Method names have verb or verb phrases names like postPayment, deletePage
 *
 */

/**
 * When constructors overloaded, use static factory methods with names that
 * describe example
 *
 * Example. Complex fulcrumPoint = Complex.FormRealNumber(23.0);
 *
 * is generally better than Complex fulcrumPoint = new Complex(23.0);
 *
 *
 */





    public class Main {
        private final String name;
        private final String email;
        private final String country;

        public Main(String name, String email, String country) {
            this.name = name;
            this.email = email;
            this.country = country;
        }


        static Main createName(String name, String email) {
            return new Main(name, email, "Argentina");
        }
        public   static void main(String[] args) {
    //        Main obj = new Main("vipin", "vipinsharma2909@gmail.com", "india");
            Main obj =  createName("vipin", "vipin.com");
            System.out.println("This is name: " + obj.name + "\n" + "This is email address: " + obj.email + "\n" + "This is country: " + obj.country);

        }
    }
