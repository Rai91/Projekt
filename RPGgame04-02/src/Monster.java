import java.util.Random;

/**
 * Created by rari on 03-02-2015.
 */
public class Monster {

    private final String name;
    private int health;
    private final int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private final static int NUM_MONSTERS = 3;


    public Monster(String name, int hitPoints, int minDamage, int maxDamage, int health) {
        this.name = name;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hitPoints = hitPoints;
    }

    public String toString() {
        return name;
    }


    // metode getDamage{
    //
    //

    public String getStatus() {
        return "Monster HP: " + hitPoints;
    }

/*    public int attack() {
        Random random = new Random();
        int attack =  random.nextInt(maxDamage - minDamage + 1) + minDamage;
        return attack;
    }

    public void defend(int pointsDamage) {
        int attackStrength = player.attack();
        hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
        System.out.println("  %s hits %s for %d HP of damage (%s)\n", player, name, attackStrength,
                getStatus());
        if (hitPoints == 0) {
            System.out.println("  " + player + " transforms the skull of " + name
                    + " into a red pancake with his stone hammer");
        }
    }
*/
    public boolean isAlive() {
        return hitPoints > 0;
    }

}