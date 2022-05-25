package derekTutorial;

public class GetTheMail implements Runnable {

    private int startTime;
    public GetTheMail(int startTime) {
        this.startTime = startTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(startTime * 1000);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Checking Mail");
    }

}
