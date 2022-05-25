package derekTutorial;

import java.util.Arrays;
public class LessonEight {

    public static void main(String[] args) {
        MonsterTwo.buildBattleBoard();
        char[][] tempBattleBoard = new char[10][10];

        // ObjectName[] ArrayName = new ObjectName[size];

        MonsterTwo[] monsters = new MonsterTwo[4];

        // MonsterTwo(int health, int attack, int movement, String name) -> constructor

        monsters[0] = new MonsterTwo(100, 20, 1, "Frank");
        monsters[0] = new MonsterTwo(100, 20, 1, "Drac");
        monsters[0] = new MonsterTwo(100, 20, 1, "Paul");
        monsters[0] = new MonsterTwo(100, 20, 1, "George");
        MonsterTwo obj = new MonsterTwo();
        obj.redrawBoard();

    }
}
