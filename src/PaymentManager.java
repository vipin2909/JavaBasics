import java.util.ArrayList;
import java.util.List;

public class PaymentManager {
    private final List<PaymentListener> paymentListeners = new ArrayList<>();
//    private final NotificationManager notificationManager = new NotificationManager();
//    private final PaymentEventLogger paymentEventLogger = new PaymentEventLogger();
    public void pay() { // -> notifies payment listener
//        notificationManager.sendNotification();
//        paymentEventLogger.logEvent();
        paymentListeners.forEach(PaymentListener::paymentMade); // p-> p.paymentMade()
    }
    public void registerListener(PaymentListener p) {
        paymentListeners.add(p);
    }
    public void unregisterPaymentListener(PaymentListener p) {
        paymentListeners.remove(p);
    }
}
