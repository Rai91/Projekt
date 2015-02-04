/**
 * Created by rari on 03-02-2015.
 */

public class Combat {


    Monster monster;
    player player;
    boolean isPlayerTurn;

    public Combat(player pl, Monster mo){
        this.player= pl;
        this.monster= mo;
        this.isPlayerTurn= true;
    }

    public void start(){
        if (isPlayerTurn){
            playerAttacks();

        }
        else {
            monsterAttacks();
        }
    }

    public void playerAttacks(){
        // mostrar per pantalla attack 1 2 o 3
        // llegir de teclat
        // player.getSkillDamage(valor)
    }

    public void monsterAttacks(){
        // monster.getDamage
    }
}
