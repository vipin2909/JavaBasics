package derekTutorial;

import java.util.Arrays;

public class MonsterTwo {

    // class variables or fields
    // you declare constants with final
    public final String TOMBSTONE = "Here is a dead MonsterTwo";

    // private fields are not visible outside the class
    private int health = 500;
    private int attack = 20;  
    private int movement = 2;

    private boolean alive = true;

    // public variables are visible outside of the class
    // You should have as few as possible public fields
    public String name = "Big MonsterTwo";
    public char nameChar1 = 'B';
    public int xPosition = 0;
    public int yPosition = 0;
    public static int numOfMonsters;

    public static char[][] battleBoard = new char[10][10];

    public static void buildBattleBoard() {

        for(char[] row: battleBoard) {
            Arrays.fill(row, '*');
        }

    }
    public static void redrawBoard() {

        int k = 1;

        while(k <= 30) {
            System.out.print('-');
            k+=1;
        }
        System.out.println();

        for(int i = 0; i < battleBoard.length; i++) {
             for(int j = 0; j < battleBoard[i].length; j++) {
                 System.out.print("|" + battleBoard[i][j] + "|");
             }
            System.out.println();
        }

        k = 1;

        while(k <= 30) {
            System.out.print('-');
            k+=1;
        }



    }




    public int getAttack() {
        return attack;
    }

    public int getMovement() {
        return movement;
    }

    public int getHealth() {
        return health;
    }

    public boolean getAlive() {
        return alive;
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

    public MonsterTwo(int newHealth, int newAttack, int newMovement, String name) {
        health = newHealth;
        attack = newAttack;
        movement = newMovement;
        this.name = name;

        int maxXBoardSpce = battleBoard.length - 1;
        int maxYBoardSpace = battleBoard[0].length - 1;

        int randNumX, randNumY;

        do {
            randNumX = (int) (Math.random() * maxXBoardSpce);
            randNumY = (int) (Math.random() * maxYBoardSpace);

        } while(battleBoard[randNumX][randNumY] != '*');

        this.xPosition = randNumX;
        this.yPosition = randNumY;
        this.nameChar1 = this.name.charAt(0);

        battleBoard[this.yPosition][this.xPosition] = this.nameChar1;
        numOfMonsters+=1;
    }
    // you can overload constructor like any other method
    // The following constructor is the one provided if you don't create any
    // default constructor
    public MonsterTwo() {
       numOfMonsters+=1;
    }

    public MonsterTwo(int newHealth) {
        health = newHealth;
    }

    public MonsterTwo(int newHealth, int newAttack) {
        this(newHealth);
        attack = newAttack;
    }

    public static void main(String[] args) {
        MonsterTwo frank = new MonsterTwo();
        System.out.println(frank.movement);
    }

}
