import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;


public class LessonEight {
    public static void main(String[] args) {
        MonsterTwo.buildBattleBoard();
        char[][] tempBattleBoard = new char[10][10];

        MonsterTwo[] Monsters = new MonsterTwo[4];
        Monsters[0] = new MonsterTwo(1000, 20, 1, "Frank");
        Monsters[1] = new MonsterTwo(500, 40, 2, "Drac");
        Monsters[2] = new MonsterTwo(1000, 20, 2, "Paul");
        Monsters[3] = new MonsterTwo(1000, 20, 2, "George");

        MonsterTwo.redrawBoard();

//        MonsterTwo Frank = new MonsterTwo(500, 20, 2, "Frank");
//        MonsterTwo Adahn = new MonsterTwo(500, 20, 2, "Adahn");
    }
}
