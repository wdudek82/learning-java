import java.util.regex.Pattern;


public class EnhancedPlayer {

    private String name;
    private int hitPints = 200;
    private String weapon;

    EnhancedPlayer(String name, int hitPints, String weapon) {
        setName(name);
        setHealth(hitPints);
        this.weapon = weapon;

    }

    private boolean nameIsValid(String name) {
        // Pattern p = Pattern.compile("[\\w-]*");
        // Matcher m = p.matcher(name);
        // boolean result = m.matches();
        return Pattern.matches("[a-zA-Z_-]+", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.nameIsValid(name)) {
            this.name = name;
        } else {
            System.out.println("The name is invalid!");
        }
    }

    public void loseHealth(int damage) {
        this.hitPints -= damage;

        if (this.hitPints <= 0) {
            System.out.println("Player knocked out");
            // Reduce number of lives remaining for the player
        }
    }

    public int getHealth() {
        return hitPints;
    }

    public void setHealth(int health) {
        if(health > 0 && health <= 200) {
            this.hitPints = health;
        } else {
            System.out.println("Given hitPints value is invalid!");
        }
    }
}
