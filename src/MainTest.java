import main.PaymentManager;
import main.PaymentListener;
import main.NotificationManager;
import main.PaymentEventLogger;

public class MainTest {
    public static void main(String[] args) {
        PaymentManager paymentManager = new PaymentManager();

//        PaymentListener p1 = new NotificationManager();

//        paymentManager.registerPaymentListener(p1);

        // for functional interface we can use lambda expression for registring event listeners

        /*  Example */
        paymentManager.registerPaymentListener(new NotificationManager());
        paymentManager.registerPaymentListener(() -> {System.out.println(":)");
            System.out.println("This is second");});

        PaymentListener p2 = new PaymentEventLogger("abcd");
        paymentManager.registerPaymentListener(p2);

        paymentManager.pay();
//        paymentManager.unregisterPaymentListener(p2);
        paymentManager.pay();

    }

}