import java.util.*;
import java.io.*;

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

    public map (){
        super();
        gameMap = new char[7][7];
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++) {
                gameMap[i][j]= 'H';
            }
        }
    }

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
    public char[][] putFreeSpaces(String[] freeSpaces) {

        for (int x = 0; x < freeSpaces.length; x++) {
            char charWallX = freeSpaces[x].charAt(0);
            char charWallY = freeSpaces[x].charAt(1);

            int freeX = Character.getNumericValue(charWallX);
            int freeY = Character.getNumericValue(charWallY);
            if (gameMap[freeX][freeY] == 0) {
                gameMap[freeX][freeY] = 'H';
            }

        }
        return gameMap;
    }
    public char putPlayerMap(int x, int y) {

        char who = gameMap[x][y];

        gameMap[x][y] = 'P';

        return who;
    }

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
        while(monster1XY == monster3XY && monster2XY == monster3XY){
            monster3XY= random.nextInt(spacesAvailable.length);
        }
        int monster3X = Integer.parseInt(spacesAvailable[monster3XY].charAt(0) + "");
        int monster3Y = Integer.parseInt(spacesAvailable[monster3XY].charAt(1) + "");
        this.gameMap[monster3X][monster3Y]= 'C';

        return gameMap;
    }

    public char[][] putOcup(int x, int y) {

        gameMap[x][y] = 'O';

        return gameMap;
    }
    public void printMap(){

             System.out.println();

            for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                System.out.print(gameMap[x][y] + " ");
            }
            System.out.println();
        }


    }


}