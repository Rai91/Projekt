/**
 * Created by abel on 30-01-2015.
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.*;

public class game {

    public static void main(String[] args) throws IOException {
        // write your code here

        Scanner in = new Scanner(System.in);

        char key;

        map map1;
        map1 = new map();

        player player1;
        player1 = new player();


        //map1.walls= new String[49];
        map1.walls = new String[]{"00", "01", "02", "03", "04", "05", "06", "16", "20", "21", "22", "23", "24", "26", "30", "36", "40", "42", "43", "44", "45", "46", "50", "60", "61", "62", "63", "64", "65", "66"};
        map1.freeSpaces = new String[]{"11", "12", "13", "14", "15", "25", "31", "32 ", "33", "34", "35", "41", "51", "52", "53", "54", "55"};
        map1.startX = 1;
        map1.startY = 0;
        map1.end = 56;

        map1.gameMap = new char[7][7];

        int positionX = map1.startX;
        int positionY = map1.startY;

        map1.gameMap = map.putWallsMap(map1.walls, map1.gameMap);
        map1.gameMap = map.putFreeSpaces(map1.freeSpaces, map1.gameMap);
        map1.gameMap = map.putPlayerMap(positionX, positionY, map1.gameMap);
        map.printMap(map1.gameMap);

        key = (char) System.in.read();
        clearConsole();
        switch (key) {
            case 'n':
                if (map1.gameMap[positionX--][positionY] == 'H' || map1.gameMap[positionX--][positionY] == 'M') {   //check up
                    map1.gameMap = map.putPlayerMap(positionX--, positionY, map1.gameMap);
                    map1.gameMap = map.putOcup(positionX--, positionY, map1.gameMap);
                    map.printMap(map1.gameMap);
                    positionX=positionX-1;


                } else if (map1.gameMap[positionX][positionY++] == 'H' || map1.gameMap[positionX][positionY++] == 'M') {   //check right
                    map1.gameMap = map.putPlayerMap(positionX, positionY++, map1.gameMap);
                    map1.gameMap = map.putOcup(positionX, positionY++, map1.gameMap);
                    map.printMap(map1.gameMap);
                    positionY=positionY+1;

                }

        }
    }




       /* map1.gameMap= map.putWallsMap(map1.walls, map1.gameMap);
        map1.gameMap= map.putFreeSpaces(map1.freeSpaces, map1.gameMap);

        map.printMap(map1.gameMap);*/



        /*static int movement (int positionX, int positionY, int lastPositionX, int lastPositionY){

        }*/
        /*public static int movement(char key, char[][] gameMap, int positionX, int positionY) {
            int cls;
            map map1;
            map1 = new map();

            switch(key)
            {
                case 'n':
                   if(gameMap[positionX--][positionY] == 'H' ||gameMap[positionX--][positionY] == 'M'){   //check up
                       map1.gameMap=map.putPlayerMap(positionX--, positionY, map1.gameMap);
                       map1.gameMap=map.putOcup(positionX--, positionY, map1.gameMap);
                       map.printMap(map1.gameMap);
                       positionX--;
                       //return positionY;


                   }else if(gameMap[positionX][positionY++] == 'H' ||gameMap[positionX][positionY++] == 'M'){   //check right
                       map1.gameMap=map.putPlayerMap(positionX, positionY++, map1.gameMap);
                       map1.gameMap=map.putOcup(positionX, positionY++, map1.gameMap);
                       map.printMap(map1.gameMap);
                       positionY++;
                      // return positionY;


                   }


            }
            clearConsole();
            return positionX;
            //return positionY;

        }*/
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    }


/*class map {
    int x;
    int y;

    String[] walls;
    String[] freeSpaces;
    char[][] gameMap;

    static char[][] putWallsMap(String[] walls, char[][] gameMap) {

        char[][] mapWalls;
        mapWalls = gameMap;

        for (int x = 0; x < walls.length; x++) {
            char charWallX = walls[x].charAt(0);
            char charWallY = walls[x].charAt(1);

            int wallX = Character.getNumericValue(charWallX);
            int wallY = Character.getNumericValue(charWallY);

            mapWalls[wallX][wallY] = 'W';

        }
        return mapWalls;
    }
    static char[][] putFreeSpaces(String[] freeSpaces, char[][] gameMap) {

        char[][] mapFreeSpaces;
        mapFreeSpaces = gameMap;

        for (int x = 0; x < freeSpaces.length; x++) {
            char charWallX = freeSpaces[x].charAt(0);
            char charWallY = freeSpaces[x].charAt(1);

            int freeX = Character.getNumericValue(charWallX);
            int freeY = Character.getNumericValue(charWallY);
            if (mapFreeSpaces[freeX][freeY] == 0) {
                mapFreeSpaces[freeX][freeY] = 'H';
            }

        }
        return mapFreeSpaces;
    }
    static void printMap(char gameMap[][]){

        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                System.out.print(gameMap[x][y] + " ");
            }
            System.out.println();
        }
    }


}*/

/*

public class game {

    public static void main(String[] args) {
        // write your code here

        map map1;
        map1 = new map();



        map1.wallsVector= new int[]{00, 01, 02};

        map1.gameMap= new String[7][7];

        for(int x : map1.wallsVector ){            //recorre un vector
            System.out.print( x );
            System.out.print(",");
        }


        //showMap()
    }
}

public class map {
    int x;
    int y;

    int wallsVector[];
    String[][] gameMap;
 */