package derekTutorial;

public class Monster {

    // class variables or fields
    // you declare constants with final
    public final String TOMBSTONE = "Here is a dead monster";

    // private fields are not visible outside the class
    private int health = 500;
    private int attack = 20;
    private int movement = 2;
    private int xPosition = 0;
    private int yPosition = 0;
    private boolean alive = true;

    // public variables are visible outside of the class
    // You should have as few as possible public fields
    public String name = "Big Monster";

    public int getAttack() {
        return attack;
    }

    public int getMovement() {
        return movement;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int decreaseHealth) {
        health = health - decreaseHealth;
        if(health < 0) {
            alive = false;
        }
    }

    public void setHealth(double decreaseHealth) {
        int intDecreaseHealth = (int) decreaseHealth;
        health = health - intDecreaseHealth;
        if(health < 0) {
            alive = false;
        }
    }

    public Monster(int newHealth, int newAttack, int newMovement) {
        health = newHealth;
        attack = newAttack;
        movement = newMovement;
    }
    // you can overload constructor like any other method
    // The following constructor is the one provided if you don't create any
    // default constructor
    public Monster() {

    }

    public Monster(int newHealth) {
        health = newHealth;
    }

    public Monster(int newHealth, int newAttack) {
        this(newHealth);
        attack = newAttack;
    }

    public static void main(String[] args) {
        Monster frank = new Monster();
        System.out.println(frank.movement);
    }

}
