import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rari on 04-02-2015.
 */
public class RpgGame {

    String key;
    String namePlayer;

    map map1;
    player player1;
    Monster monster1, monster2, monster3;
    Combat combat;

    String[] walls;

    public RpgGame () throws IOException{
        // write your code here

        BufferedReader buffer = new BufferedReader(new InputStreamReader((System.in)));



        map1 = new map();


        monster1 = new Monster("Charizard", 1, 2, 5, 20);
        monster2 = new Monster("Blastoise", 1, 1, 4, 30);
        monster3 = new Monster("Bulbasaur", 1, 10, 15, 15);


        walls = new String[]{"00", "01", "02", "03", "04", "05", "06", "16", "20", "21", "22", "23", "24", "26", "30", "36", "40", "42", "43", "44", "45", "46", "50", "60", "61", "62", "63", "64", "65", "66"};

        map1.setPlayerX(1);
        map1.setPlayerY(0);
        map1.setEnd(18);

        int positionX = map1.getPlayerX();
        int positionY = map1.getPlayerY();
        int End = map1.getEnd();

        System.out.println("WELCOME TO THE GAME");
        System.out.println("Introduce a name for your player: ");
            namePlayer = buffer.readLine();
        player1 = new player(namePlayer);
        System.out.println("WELCOME " + namePlayer+ ", Walk through the map, fight with the monsters and try to leave... ALIVE!");

        map1.putWallsMap(walls);
        map1.putPlayerMap(positionX, positionY);
        map1.randomMonsters();
        map1.printMap();

        System.out.println("\nPress n and Enter to move the player:");
        System.out.println("Press x and Enter if you want to exit the game:");

        boolean stop = false;
        int cont=0;

        while (!stop) {


            key = buffer.readLine();

            if (key.equals("n")) {

                if ((positionX - 1) >= 0 && (map1.getPosition(positionX - 1, positionY) == 'H' || map1.getPosition(positionX - 1, positionY) == 'A' || map1.getPosition(positionX - 1, positionY) == 'B' || map1.getPosition(positionX - 1, positionY) == 'C' )) {   //check up
                    movePlayer(positionX, positionY, -1, 0, map1);
                    cont++;

                } else {
                    if ((positionX + 1) <= 6 && (map1.getPosition(positionX + 1, positionY) == 'H' || map1.getPosition(positionX + 1, positionY) == 'A' || map1.getPosition(positionX + 1, positionY) == 'B' || map1.getPosition(positionX + 1, positionY) == 'C')) {   //check up
                        movePlayer(positionX, positionY, +1, 0, map1);
                        cont++;

                    } else {
                        if ((positionY - 1) >= 0 && (map1.getPosition(positionX, positionY - 1) == 'H' || map1.getPosition(positionX, positionY - 1) == 'A' || map1.getPosition(positionX, positionY - 1) == 'B' || map1.getPosition(positionX, positionY - 1) == 'B')) {   //check up
                            movePlayer(positionX, positionY, 0, -1, map1);
                            cont++;

                        } else {
                            if ((positionY + 1) <= 6 && (map1.getPosition(positionX, positionY + 1) == 'H' || map1.getPosition(positionX, positionY + 1) == 'A' || map1.getPosition(positionX, positionY + 1) == 'B' || map1.getPosition(positionX, positionY + 1) == 'C')) {   //check up
                                movePlayer(positionX, positionY, 0, +1, map1);
                                cont++;

                            } else {
                                if ((cont == End) /*& (isAlive==true)*/){
                                    System.out.println("Congratulations!!! " + namePlayer+ " You past the RPG Game");
                                    break;
                                }
                            }

                        }
                    }
                }

            }

            if (key.equals("x")) {
                stop = true;
                System.out.println("You are leaving the game, Thanks for playing "+ namePlayer);
                continue;

            }

            positionX = map1.getPlayerX();
            positionY = map1.getPlayerY();

            map1.printMap();
            System.out.println("\nPress n and Enter to move the player");
            System.out.println("Press x and Enter if you want to exit the game:");

        }

    }

    public void movePlayer(int positionX, int positionY, int dirX, int dirY, map map1) {

        char who= map1.putPlayerMap(positionX + dirX, positionY + dirY);
        map1.putOcup(positionX, positionY);
        map1.setPlayerX(positionX + dirX);
        map1.setPlayerY(positionY + dirY);

        switch(who) {
            case 'A':
                System.out.println("Entering combat mode against monster A: ");
                combat = new Combat(player1, monster1);
                break;
            case 'B':
                System.out.println("Entering combat mode against monster B: ");
                combat = new Combat(player1, monster2);
                break;
            case 'C':
                System.out.println("Entering combat mode against monster C: ");
                combat = new Combat(player1, monster3);
                break;
        }


        }

    }

