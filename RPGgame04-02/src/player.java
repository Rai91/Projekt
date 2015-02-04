import java.util.Random;

/**
 * Created by abel on 30-01-2015.
 */
public class player {

    private final String name;
    private final int hitPoints;
    private String [] skillNames;
    private int [] skillDamages;

    public player(String name) {
        this.name = name;

        this.hitPoints = 3;
        this.health = 100;

        skillNames = new String[hitPoints];
        skillNames[0] = "finger touch";
        skillNames[1] = "smash";
        skillNames[2] = "super punch";

        skillDamages = new int[hitPoints];
        skillDamages[0]= 7;
        skillDamages[1]= 13;
        skillDamages[2]= 25;

    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getSkillNames(int i) {
        return skillNames[i-1];
    }

    public int getSkillDamages(int i) {
        return skillDamages[i-1];
    }

    public int getHealth() {
        return health;
    }

    public int decrementHealth(int decrement) {
        this.health -= decrement;
        return this.health;
    }

    private int health;




/*    public int attack() {
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public void defend(Monster monster) {
        int attackStrength = monster.attack();
        hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
        System.out.println("  " + name + " is hit for %d HP of damage (%s)\n", attackStrength,
                getStatus());
        if (hitPoints == 0) {
            System.out.println("  " + name + " has been defeated");
        }
    }

  */  public boolean isAlive() {
        return hitPoints > 0;
    }

    public String getStatus() {
        return "Player HP: " + hitPoints;
    }

    public String toString() {
        return name;
    }

}
