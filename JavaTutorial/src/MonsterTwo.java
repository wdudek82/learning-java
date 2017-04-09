import java.util.Arrays;


public class MonsterTwo {

    // Battle Board
    static char[][] battleBoard = new char[10][10];

    public static void buildBattleBoard() {
        for (char[] row : battleBoard) {
            Arrays.fill(row, '*');
        }
    }

    public static void drawBattlefieldBorder() {
        int count = 1;
        while (count <= 30) { System.out.print('-'); count++; }
        System.out.println();
    }

    public static void redrawBoard() {
        drawBattlefieldBorder();

        for (int row = 0; row < battleBoard.length; row++) {
            for (int column = 0; column < battleBoard[row].length; column++) {
                System.out.print("|" + battleBoard[row][column] + "|");
            }
            System.out.println();
        }

        drawBattlefieldBorder();
    }

    // Contant
    public final String TOMBSTONE = "Here Lies a Dead monster";

    private int health = 500;
    private int attack = 20;
    private int movement = 2;
    private boolean alive = true;

    public String name = "Big Monster";
    public char nameChar1 = 'B';
    public int xPosition = 0;
    public int yPosition = 0;
    public static int numOfMonsters = 0;

    public int getHealth() { return health; }
    public void setHealth(int decreaseHealth) {
        health -= decreaseHealth;
        if (health <= 0) {
            alive = false;
        }
    }

    public void setHealth(double decrease) {
        int intDecreaseHealth = (int) decrease;
        setHealth(intDecreaseHealth);
    }

    public boolean getAlive() { return alive; }

    public int getAttack() { return attack; }
    public void setAttack(int newAttack) { attack = newAttack; }

    public int getMovement() { return movement; }
    public void setMovement(int newMovement) { movement = newMovement; }

    public void moveMonster(MonsterTwo[] monsters, int arrayItemIndex) {
        boolean isSpaceOpen = true;
        int maxXBoardSpace = battleBoard.length - 1;
        int maxYBoardSpace = battleBoard[0].length - 1;

        while (isSpaceOpen) {
            int randMoveDirection = (int) (Math.random() * 4);
            int randMoveDistance = (int) (Math.random() * (this.getMovement() + 1));

            System.out.println("Distance: " + randMoveDistance + ", Direction: " + randMoveDirection);

            battleBoard[this.yPosition][this.xPosition] = '*';

            if (randMoveDirection == 0) {
                if ((this.yPosition - randMoveDistance) < 0) {
                    this.yPosition = 0;
                } else {
                    this.yPosition -= randMoveDistance;
                }
            } else if (randMoveDirection == 1) {
                if ((this.xPosition + randMoveDistance) > maxXBoardSpace) {
                    this.xPosition = maxXBoardSpace;
                } else {
                    this.xPosition += randMoveDistance;
                }
            } else if (randMoveDirection == 2) {
                if ((this.yPosition + randMoveDistance) > maxYBoardSpace) {
                    this.yPosition = maxYBoardSpace;
                } else {
                    this.yPosition += randMoveDistance;
                }
            } else if (randMoveDirection == 3) {
                if ((this.xPosition - randMoveDistance) < 0) {
                    this.xPosition = 0;
                } else {
                    this.xPosition -= randMoveDistance;
                }
            }

            for (int i = 0; i < monsters.length; i++) {
                if (i == arrayItemIndex) {
                    continue;
                }

                if (!onMySpace(monsters, i, arrayItemIndex)) {
                    isSpaceOpen = false;
                }
            }

        } // END OF WHILE LOOP

        battleBoard[this.yPosition][this.xPosition] = this.nameChar1;

    } // END OF moveMonster

    public boolean onMySpace(MonsterTwo[] monsters, int indexToCheck1, int indexToCheck2) {
        if ((monsters[indexToCheck1].xPosition) == (monsters[indexToCheck2].xPosition) &&
                (monsters[indexToCheck1].yPosition) == (monsters[indexToCheck2].yPosition))  {
            return true;
        } else {
            return false;
        }
    } // END OF onMySpace

    public MonsterTwo(int health, int attack, int movement, String name) {
        this.health = health;
        this.attack = attack;
        this.movement = movement;
        this.name = name;

        int maxXBoardSpace = battleBoard.length - 1;
        int maxYBoardSpace = battleBoard[0].length - 1;

        int randNumX, randNumY;

        do {
            randNumX = (int) (Math.random() * maxXBoardSpace);
            randNumY = (int) (Math.random() * maxYBoardSpace);
        } while (battleBoard[randNumX][randNumY] != '*');

        this.xPosition = randNumX;
        this.yPosition = randNumY;

        this.nameChar1 = this.name.charAt(0);

        battleBoard[this.yPosition][this.xPosition] = this.nameChar1;
        numOfMonsters++;
    }

    public MonsterTwo() { numOfMonsters++; }

    public static void main(String[] args) {}
}
