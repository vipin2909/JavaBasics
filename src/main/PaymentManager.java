package main;

import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    private final List<PaymentListener> paymentListeners = new ArrayList<>();
    // if we do like this means the payment manager is highly coupled with both the
    // notification manager and payment event logger
//    private final NotificationManager notificationManager = new NotificationManager();
//    private final PaymentEventLogger paymentEventLogger = new PaymentEventLogger();
    public void pay() { // --> Notify some payment listeners
        // payment manager is highly coupled with both notification manager and payment event logger

        // 1. if you write code like this, this means for any payment you always have notification sent and
        // always logged information in the database
        // but in real world situation you sometimes need to do only one and sometimes both of them


        // 1st advantage of observer design pattern
        // all objects subjects are completly decoupled
        //
//        notificationManager.sendNotification();
//        paymentEventLogger.logEvent();



        // < ---------            Payment Listener Code Started ---------------------> //
        // do something
        paymentListeners.forEach(PaymentListener::paymentMade); // p = p.paymentMade

    }

    public void registerPaymentListener(PaymentListener p) {
        paymentListeners.add(p);
    }
    public void unregisterPaymentListener(PaymentListener p) {
        paymentListeners.remove(p);
    }
}
