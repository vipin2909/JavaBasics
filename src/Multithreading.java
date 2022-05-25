public class Multithreading {
    public static void main(String[] args) {
//        MultithreadThing myThing2 = new MultithreadThing();
        // can also use myThing.run() -> this won't do it in sepread thread but it will create (or kick off) a new Thread
        for(int i = 0; i < 5; i++) {
            MultithreadThing myThing = new MultithreadThing(i);
            myThing.start();
            myThing.isAlive();
//            try {
//                myThing.join();
//            }
//            catch(InterruptedException e) {
//
//            }
        }
//        throw new RuntimeException();
//        myThing.start();
//        myThing2.start();
        // start method in this java will branch of new thread and start running this method


    }
}
