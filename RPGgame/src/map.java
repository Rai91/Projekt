class map {
    int startX;
    int startY;
    int end;

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
    static char[][] putPlayerMap(int x, int y, char[][] gameMap) {

        char[][] mapPlayer;
        mapPlayer = gameMap;


        mapPlayer[x][y] = 'P';

        return mapPlayer;
    }
    static char[][] putOcup(int x, int y, char[][] gameMap) {

        char[][] mapOcup;
        mapOcup = gameMap;


        mapOcup[x][y] = 'O';

        return mapOcup;
    }
    static void printMap(char gameMap[][]){

        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                System.out.print(gameMap[x][y] + " ");
            }
            System.out.println();
        }
    }


}