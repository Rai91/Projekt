/**
 * Created by raimon and abel.
 *
 * This is the monster class, here we create the monster with the different constant variables, like minDamage, MaxDamage
 * and this variables are past to the monster object. In this class we also have to create the method attack, is a random
 * method that uses the minDamage and the maxDamage for take a number between them and make the attack, and the method
 * for known if the monster is alive. We also create a method for know anytime the health of the monster.
 */

import java.util.Random;

public class Monster {

    //Static variables of the class, all except the health.

    private final String name;
    private int health;
    private final int skills;
    private final int minDamage;
    private final int maxDamage;
    private final static int NUM_MONSTERS = 3;


    // Values that we pass to the object monster.

    public Monster (String name, int skills, int minDamage, int maxDamage, int health) {
        this.name = name;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.skills = skills;
    }

    public String toString() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int decrHealth(int decrement) {
        this.health -= decrement;
        return this.health;
    }

    //Method attack, it will create a random number between the minDamage and the maxDamage of the monster object
    //and it will return that damage in the combat against the player.

    public int attack() {
        Random random = new Random();
        int attack =  random.nextInt(maxDamage - minDamage + 1) + minDamage;
        return attack;
    }

    // Create the method isAlive it will compare the health of the monster with the number 0, if the health is bigger than 0
    // then it will return that the monster is alive and it will continue the fight.

    public boolean isAlive() {
        return health > 0;
    }

}