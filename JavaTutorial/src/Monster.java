
public class Monster {

    public final String TOMBSTONE = "Here Lies a Dead monster";

    private int health = 500;
    private int attack = 20;
    private int movement = 2;
    private int xPosition = 0;
    private int yPosition = 0;
    private boolean alive = true;

    public String name = "Big Monster";

    public int getHealth() {
        return health;
    }

    public void setHealth(int decreaseHealth) {
        health -= decreaseHealth;
        if (health <= 0) {
            alive = false;
        }
    }

    // overloaded setter for health
    public void setHealth(double decrease) {
        int intDecreateHealth = (int) decrease;
        setHealth(intDecreateHealth);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttact(int newAttack) {
        attack = newAttack;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int newMovement) {
        movement = newMovement;
    }

    public Monster(int health, int attack, int movement) {
        this.health = health;
        this.attack = attack;
        this.movement = movement;
    }

    // Default Constructor
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

        Monster Frank = new Monster();

        System.out.print(Frank.attack);

    }

}