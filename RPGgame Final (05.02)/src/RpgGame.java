/**
 * Created by raimon and abel.
 *
 * This is the main program where we call all the classes and methods.
 * The public class RpgGame call the class map for draw the map, put the player and monsters.
 * Also we call the classes Monster and player for make the objects of the game
 * We can find what is the next free space available or monster to fight in the map
 * First we show the first map wth all the characters in the correct place, after we move throw the if conditions
 * moving and showing the updates of the map
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RpgGame {

    String key;
    String namePlayer;

    map map1;  // object map
    player player1;  //object player of the game
    Monster monster1, monster2, monster3;   // object of the 3 monsters on the map
    Combat combat;  // object combat

    String[] walls;

    public RpgGame () throws IOException{
        // write your code here

        BufferedReader buffer = new BufferedReader(new InputStreamReader((System.in)));



        map1 = new map();

        //these are the 3 monsters that we put in the map randomly

        monster1 = new Monster("Charizard", 1, 5, 10, 15);
        monster2 = new Monster("Blastoise", 1, 12, 16, 30);
        monster3 = new Monster("Bulbasaur", 1, 20, 30, 40);

        //String vector of the walls of the map

        walls = new String[]{"00", "01", "02", "03", "04", "05", "06", "16", "20", "21", "22", "23", "24", "26", "30", "36", "40", "42", "43", "44", "45", "46", "50", "60", "61", "62", "63", "64", "65", "66"};


        map1.setPlayerX(1); //position of the vector map where ther player start
        map1.setPlayerY(0);
        map1.setEnd(18);  //steps before arrive to the end of the game

        int positionX = map1.getPlayerX(); //the position where the player is
        int positionY = map1.getPlayerY();
        int End = map1.getEnd();    //position end of the map

        System.out.println("WELCOME TO THE GAME");
        System.out.println("Introduce a name for your player: ");
            namePlayer = buffer.readLine();
        player1 = new player(namePlayer);   //save the input
        System.out.println("WELCOME " + namePlayer+ ", Walk through the map, fight with the monsters and try to leave... ALIVE!");

        //call the methods in the class map

        map1.putWallsMap(walls);    //put the string of the walls in teh map
        map1.putPlayerMap(positionX, positionY);    //put where the player is in the map
        map1.randomMonsters();  //put the 3 monsters randomly in the map
        map1.printMap();    //draw the map with walls, player and monsters

        boolean stop = false;
        int cont=0;

        while (!stop) {

            //input key and with the IF's we can find what is the next free space available or monster to fight H = free
            //and A is monster1,B monster2 and C monster 3

            System.out.println("\nPress n and Enter to move the player");
            System.out.println("Press x and Enter if you want to exit the game:");
            key = buffer.readLine();

            if (key.equals("n")) {

                //gameposition check what is on the 4 possibilities throw the vector for move the player

                if ((positionX - 1) >= 0 && (map1.getPosition(positionX - 1, positionY) == 'H' || map1.getPosition(positionX - 1, positionY) == 'A' || map1.getPosition(positionX - 1, positionY) == 'B' || map1.getPosition(positionX - 1, positionY) == 'C')) {   //check up

                    //call the method movePlayer for input the new position

                    stop = movePlayer(positionX, positionY, -1, 0, map1);
                    cont++;

                } else {
                    if ((positionX + 1) <= 6 && (map1.getPosition(positionX + 1, positionY) == 'H' || map1.getPosition(positionX + 1, positionY) == 'A' || map1.getPosition(positionX + 1, positionY) == 'B' || map1.getPosition(positionX + 1, positionY) == 'C')) {   //check up
                        stop = movePlayer(positionX, positionY, +1, 0, map1);
                        cont++;

                    } else {
                        if ((positionY - 1) >= 0 && (map1.getPosition(positionX, positionY - 1) == 'H' || map1.getPosition(positionX, positionY - 1) == 'A' || map1.getPosition(positionX, positionY - 1) == 'B' || map1.getPosition(positionX, positionY - 1) == 'B')) {   //check up
                            stop = movePlayer(positionX, positionY, 0, -1, map1);
                            cont++;

                        } else {
                            if ((positionY + 1) <= 6 && (map1.getPosition(positionX, positionY + 1) == 'H' || map1.getPosition(positionX, positionY + 1) == 'A' || map1.getPosition(positionX, positionY + 1) == 'B' || map1.getPosition(positionX, positionY + 1) == 'C')) {   //check up
                                stop = movePlayer(positionX, positionY, 0, +1, map1);
                                cont++;

                            } else {
                                if ((cont == End)) {
                                    System.out.println("Congratulations!!! " + namePlayer + " You past the RPG Game with: " + player1.getHealth() + " HP");
                                    break;
                                }
                            }

                        }
                    }
                }

            }

            //if we press x the game will end

            if (key.equals("x")) {
                stop = true;
                System.out.println("You are leaving the game with: " + player1.getHealth() + " HP, Thanks for playing");
                continue;

            }

            //after check and move to the new position return the new position of the player

            positionX = map1.getPlayerX();
            positionY = map1.getPlayerY();

            //draw the map and put an X where the player is placed when he ends the game

            if (stop) {
                map1.putX(positionX, positionY);
            }
            map1.printMap();
        }

    }
    //movePlayer uses the class map for move the player and check if there is a monster to fight

    public boolean movePlayer(int positionX, int positionY, int dirX, int dirY, map map1) throws IOException {

        char who= map1.putPlayerMap(positionX + dirX, positionY + dirY);
        map1.putOcup(positionX, positionY);
        map1.setPlayerX(positionX + dirX);
        map1.setPlayerY(positionY + dirY);

        boolean keepAlive;

        //check if in the who variable there is a monster and call the method for combat, and check if the player is alive.

        switch(who) {
            case 'A':
                System.out.println("Entering combat mode against monster A: ");
                combat = new Combat(player1, monster1);
                keepAlive= combat.start();
                break;
            case 'B':
                System.out.println("Entering combat mode against monster B: ");
                combat = new Combat(player1, monster2);
                keepAlive= combat.start();
                break;
            case 'C':
                System.out.println("Entering combat mode against monster C: ");
                combat = new Combat(player1, monster3);
                keepAlive= combat.start();
                break;
            case 'H':
                System.out.println("Move....");
                keepAlive= true;
                break;
            default:
                keepAlive= true;
                break;
        }

        if(keepAlive){
            return false;
        }
        else {
            return true;
        }


    }
}

