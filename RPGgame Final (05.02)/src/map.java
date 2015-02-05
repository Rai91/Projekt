/**
 * Created by raimon and abel.
 *
 * In the class map we make the map aplying all the changes that we order from RpgGame class and create randomly the
 * positions of the monsters
 * We make all the getters and setters for all variables of the class map amd make them available from all the classes
 * We print the map with the different methods like, putwalls, playerposition, occupy, or the random monster.
 * We replace all the initial letters with some different symbols, for make the game more comfortable to play for the players.
  */

import java.util.*;

// Declare private variables for the player

class map {
    private int playerX;
    private int playerY;
    private int end;

    char[][] gameMap;

    public int getPlayerX(){
        return this.playerX;
    }

    public void setPlayerX(int playerX){
        this.playerX= playerX;
    }

    public int getPlayerY(){
        return this.playerY;
    }

    public void setPlayerY(int playerY){
        this.playerY= playerY;
    }

    public int getEnd(){
        return this.end;
    }

    public void setEnd(int end){
        this.end = end;
    }

    public char getPosition(int x, int y){
        return gameMap[x][y];
    }

    //Create the method for put the X on the map when the game is finish
    public void putX(int x, int y){
        gameMap[x][y]= 'X';
    }

    public map (){
        super();
        gameMap = new char[7][7];
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++) {
                gameMap[i][j]= 'H';
            }
        }
    }

// Create the method putWalls, that will write on the map the character "W", and will return the gamemap

    public char[][] putWallsMap(String[] walls) {

        for (int x = 0; x < walls.length; x++) {
            char charWallX = walls[x].charAt(0);
            char charWallY = walls[x].charAt(1);

            int wallX = Character.getNumericValue(charWallX);
            int wallY = Character.getNumericValue(charWallY);

            this.gameMap[wallX][wallY] = 'W';

        }
        return gameMap;
    }

    // Create the method putplayermap, that will write on the map the character "P", on the position that the player is,
    // and will return the variable who.

    public char putPlayerMap(int x, int y) {

        char who = gameMap[x][y];

        gameMap[x][y] = 'P';

        return who;
    }

    // Create the method randommonsters, that will create a random position on the map and will put the monsters there,
    // we can put on the map the 3 different types of monsters also randomly, and we return the gamemap.

    public char [][] randomMonsters() {

        String [] spacesAvailable = new String [18];
        int monsterPositionVector = 0;
        Random  random = new Random();
        for(int i=0;i<gameMap.length;i++){
            for(int j=0;j<gameMap.length;j++) {
                if (gameMap[i][j] == 'H') {
                    spacesAvailable[monsterPositionVector]=(i*10 +j+"");
                    monsterPositionVector++;
                }
            }
        }
        // MONSTER 1
        int monster1XY = random.nextInt(spacesAvailable.length);
        int monster1X = Integer.parseInt(spacesAvailable[monster1XY].charAt(0)+"");
        int monster1Y = Integer.parseInt(spacesAvailable[monster1XY].charAt(1) + "");
        this.gameMap[monster1X][monster1Y]= 'A';
        // MONSTER 2
        int monster2XY = random.nextInt(spacesAvailable.length);
        while(monster1XY == monster2XY){
            monster2XY= random.nextInt(spacesAvailable.length);
        }
        int monster2X = Integer.parseInt(spacesAvailable[monster2XY].charAt(0) + "");
        int monster2Y = Integer.parseInt(spacesAvailable[monster2XY].charAt(1) + "");
        this.gameMap[monster2X][monster2Y]= 'B';
        // MONSTER 3
        int monster3XY = random.nextInt(spacesAvailable.length);
        while(monster1XY == monster3XY || monster2XY == monster3XY){
            monster3XY= random.nextInt(spacesAvailable.length);
        }
        int monster3X = Integer.parseInt(spacesAvailable[monster3XY].charAt(0) + "");
        int monster3Y = Integer.parseInt(spacesAvailable[monster3XY].charAt(1) + "");
        this.gameMap[monster3X][monster3Y]= 'C';

        return gameMap;
    }

    // We use that method for print on the map the character 'O' when the player has been on the last position. We use the
    // position of the player, and we return the gamemap.

    public char[][] putOcup(int x, int y) {

        gameMap[x][y] = 'O';

        return gameMap;
    }

    // This method print the map of a dimensions [7][7]

    public void printMap(){
        char[][] gamePrint;
        gamePrint = new char[7][7];
        gamePrint = gameMap;
        System.out.println();

        //replace the letters of the map for symbols
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                if (gameMap[x][y]=='W') {
                    System.out.print((char) (9781)); //9781 19966
                }
                if (gameMap[x][y]=='H') {
                    System.out.print((char) (59370));
                }
                if (gameMap[x][y]=='O') {
                    System.out.print((char) (59370));
                }
                if (gameMap[x][y]=='P') {
                    System.out.print((char) (9786));
                }
                if (gameMap[x][y]=='X') {
                    System.out.print((char) (9760));
                }
                if (gameMap[x][y]=='A') {
                    System.out.print((char) (9398));
                }
                if (gameMap[x][y]=='B') {
                    System.out.print((char) (9399));
                }
                if (gameMap[x][y]=='C') {
                    System.out.print((char) (9400));
                }
            }
            System.out.println();
        }

    }

}