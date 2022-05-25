package derekTutorial;

public class LessonSeven {

    static int num = 9;
    public static void main(String[] args) {
        Monster frank = new Monster();
        frank.name = "Frank";
        System.out.println(frank.getAttack());
        LessonSeven obj = new LessonSeven();
        obj.hello();
    }

    void hello() {
        System.out.println("say hello to "+num);

    }

}
