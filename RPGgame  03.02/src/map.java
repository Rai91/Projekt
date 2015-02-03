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
    public char[][] putPlayerMap(int x, int y) {

        gameMap[x][y] = 'P';

        return gameMap;
    }

    public char [][] randomMonsters() {

        String [] spacesAvailable = new String [18];
        int monsterPositionVector = 0;
        Random  random = new Random();
        for(int i=0;i<gameMap.length;i++){
            for(int j=0;j<gameMap.length;j++) {
                if (gameMap[i][j] == 'H') {
                    spacesAvailable[monsterPositionVector]= Integer.toString(i*10 +j);
                    System.out.println(spacesAvailable[monsterPositionVector] + " ");
                    monsterPositionVector++;
                }
            }
        }

        int monsterXY = Integer.valueOf(spacesAvailable[random.nextInt(18)]);
        char charMonsterX = spacesAvailable[monsterXY].charAt(0);
        char charMonsterY = spacesAvailable[monsterXY].charAt(1);

        int monsterX = Character.getNumericValue(charMonsterX);
        int monsterY = Character.getNumericValue(charMonsterY);

        this.gameMap[monsterX][monsterY]= 'M';

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