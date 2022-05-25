package derekTutorial;

public class LessonSeventeen {

    public static void main(String[] args) {
        Thread getTime = new GetTime20();

        Runnable getMail = new GetTheMail(10);
        Runnable getTheMail2 = new GetTheMail(20);

        getTime.start();
        new Thread(getMail).start();
        new Thread(getTheMail2).start();
    }

}
