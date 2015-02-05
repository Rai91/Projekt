/**
 * Created by raimon and abel
 *
 *This is the combat class, here it will happen the fight with the player and the monster.
 * We create a combat class and we pass to this class the objects player and monster, and make a boolean for know which is the next on the turn.
 * Then we make a boolean class called start and this will initialize the combat against the two objects, inside this class, we will show in the beginning the health
 * of the monster, and player, and the turn. After the player turn, it will swap and it will be the monster turn.
 * Inside both turns, we have to call the method player attack inside the player turn, and monster attack inside the monster turn.
 * After the fight, we have to compare if monster is not alive, if is not, then show a message that the player won the battle and he can continue
 * if not, then show a message than the player lost the battle against the monster and the game is finish.
 * In this class we make 2 different classes, the player attacks and the monster attacks.
 * The player attacks will ask for an input and will select an skill. With that skill will attack the health of the monster and will decrement it on the value
 * of the skill. After that will return isAlive.
 * The monster attacks will show a message that is the monster turn and will wait for an input in this case a "enter".
 * When the enter is press it, the monster will attack with his unique skill and with a random number from the class attack.
 * After the attack, it will decrement the health from the player and it will return the method isAlive as well.
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// This is the class public combat

public class Combat  {



    BufferedReader buffer = new BufferedReader(new InputStreamReader((System.in)));  // create a new variable for an input

    Monster monster;  //creation of the objects
    player player;
    boolean isPlayerTurn;

    // Method combat with the two objects assign it

    public Combat(player pl, Monster mo){
        this.player= pl;
        this.monster= mo;
        this.isPlayerTurn= true;
    }

    // This is the method for change the turn, we use a boolean start that will change between player attack, or monster attack
    // depends of the return of this 2 methods.

    public boolean start() throws IOException{
        System.out.println("Player health: "+player.getHealth()+", Monster health: "+monster.getHealth());
        boolean alive=true;
        while(alive) {

            if (isPlayerTurn) {
                alive = playerAttacks();
                isPlayerTurn= false;
            } else {
                alive = monsterAttacks();
                isPlayerTurn= true;
            }
        }

        // Here we compare if the monster is not alive, then we will show a message that the player won the fight.

        if(!monster.isAlive()){
            System.out.println("Congratulations, victory!, you still have " + player.getHealth() + " HP");
            return true;
        }

        // Here we show the opposite message, if the monster is alive after the fight means that the player is dead
        //so we show a message to the screen that game is OVER and end the game.

        else{
            System.out.println("Ups..... you're dead! The monster still have " + monster.getHealth() + " HP");
            System.out.println("END OF THE GAME");
            return false;
        }
    }

    // Method playerAttacks, this method will show a number of skill to use, will save it, and will use depends of the value.
    // After that, will decrement the health of the monster and will show the current status of the fight. In the end will
    // return a variable isAlive.

    public boolean playerAttacks() throws IOException{
        System.out.println("Choose your skill for destroy the monster (1: Finger Touch, 2: Smash, 3: Super Punch)");
        int num = Integer.parseInt(buffer.readLine());
        int damageSkill = player.getSkillDamages(num);
        monster.decrHealth(damageSkill);
        System.out.println("damage: "+damageSkill+", monster health: "+monster.getHealth());
        return monster.isAlive();
    }

    // Method monsterAttacks, this method will show a text that says is the monster turn, and it will wait for an enter input.
    // After that, monster will attack with the method attack in the class monster and it will make some damage to the player.
    // The health of the player will be decrement about the value of the damage from the monster attack.
    // The next step is show the status of the fight and on the end return the value of the boolean variable isAlive.

    public boolean monsterAttacks()throws IOException{
        System.out.println("Now monster attacks (press Enter)");
        buffer.readLine();
        int damageSkill = monster.attack();
        player.decrHealth(damageSkill);
        System.out.println("damage: "+damageSkill+", player health: "+player.getHealth());
        return player.isAlive();
    }
}

