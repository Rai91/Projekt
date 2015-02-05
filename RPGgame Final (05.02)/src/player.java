/**
 * Created by raimon and abel.
 *
 * This is the player class, here we create the player with the different constant variables, like skills, skillNames, skillDamages and health.
 * This variables are past to the player object that we create on the rpgGame class. We create all the getters and setters that we need for call from
 * other classes. In this class we just create the method isAlive for the player that it works on the same way than the monster.
 * The class for make the player attacks is create it on the combat class.
 * Here we also create the class for decrement the health of the player when is fighting against the monster.
 */


public class player {

    //Static variables of the class, all except the health.

    private final String name;
    private  final int skills;
    private final String [] skillNames;
    private final int [] skillDamages;
    private int health;

    // Values that we pass to the object player create it on the rpgGame.

    public player(String name) {

        this.name = name;
        this.skills = 3;
        this.health = 110;

        skillNames = new String[skills];
        skillNames[0] = "finger touch";
        skillNames[1] = "smash";
        skillNames[2] = "super punch";

        skillDamages = new int[skills];
        skillDamages[0]= 7;
        skillDamages[1]= 13;
        skillDamages[2]= 25;

    }

    public String toString() {
        return name;
    }

    public int getSkillDamages(int i) {
        return skillDamages[i-1];
    }

    public int getHealth() {
        return health;
    }

    // Method that is decrementing the health of the player during a fight against a monster.

    public int decrHealth(int decrement) {
        this.health -= decrement;
        return this.health;
    }

    // Create the method isAlive it will compare the health of the player with the number 0, if the health is bigger than 0
    // then it will return that the player is still alive and it will continue the fight or the movement in the map.

    public boolean isAlive() {
        return health > 0;
    }

}


