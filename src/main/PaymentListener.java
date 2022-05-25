package main;

@FunctionalInterface
public interface PaymentListener {

    // this metho represent verb which is in the past
    // if you have only one method inside an interface than this would be termed as functional interface
    void paymentMade();
//    void payment();
}
