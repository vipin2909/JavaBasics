public class Observer {

    public static void main(String[] args) {
        System.out.println("This is example of observer design pattern");

        // if you don't have a specific problem that a design pattern solves then don't implement design pattern
        // they are not best practices but they are only best accepted solutions to some known problem

        // Observer -> defines behaviour of two objects

        // first advantage of observer pattern is it decoupled the subject and listener -> we can register and unregister listeners
        // the payment manager doesn't need to know that payment event logger and notification manager
        // payment manager just need to know that there is some one who listens and forward it accordingly
        PaymentManager paymentManager = new PaymentManager();

//        PaymentListener p1 = new NotificationManager();
//        paymentManager.registerListener(p1);
        // lambda expressions
        paymentManager.registerListener(() -> System.out.println(":)"));
//        paymentManager.registerListener(new NotificationManager());
        PaymentListener p2 = new PaymentEventLogger("abcd");
        paymentManager.registerListener(p2);

//        paymentManager.registerListener(() -> new PaymentEventLogger());
        paymentManager.pay();
//        paymentManager.unregisterPaymentListener(() -> System.out.println(":)"));
        paymentManager.unregisterPaymentListener(p2);
        paymentManager.pay();

    }
}
