public class MultithreadThing extends Thread {
    private int threadNumber;
    public MultithreadThing(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(i + " from thread "+threadNumber);
//            System.out.println();
//            if(threadNumber == 3) {
//                throw new RuntimeException();
//            }
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                System.out.println("catch block");
            }
        }
    }
}

// implementing a runnable interface is good idea because java doesn't allow multiple inheritance
// so we can't access multiple classes other than thread class