// payment listener is just way to abstractly represent some object observing payment manager
@FunctionalInterface
public interface PaymentListener {

   // when this is called the payment has already been made

    void paymentMade();

}
