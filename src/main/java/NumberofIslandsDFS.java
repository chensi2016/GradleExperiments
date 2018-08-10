public class NumberofIslandsDFS {
    char[][] grid;
    int[][] state;
    int length;
    public int numIslands(char[][] grid) {
        this.grid = grid;

        if ( grid.length == 0 ) {
            return 0;
        }
        int gridRow = grid.length;
        int gridCol = grid[0].length;
        state = new int[gridRow][gridCol];

        int number = 0;
        for ( int i = 0; i < gridRow; i++) {
            for ( int j = 0; j < gridCol; j++)
            {
                if ( grid[i][j] == '1' && state[i][j] == 0 ) {
                    DFS(i, j);
                    number++;
                }
            }
        }
        return number;
    }
    void DFS(int row, int col) {
        if (  row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || state[row][col] == 1 || grid[row][col] == '0'){
            return;
        }
        int[][] nearbyNode = getNearby(row, col);
        state[row][col] = 1;
        for ( int i = 0; i < 4; i++ ) {
            int nextRow = nearbyNode[i][0];
            int nextCol = nearbyNode[i][1];
            DFS(nextRow, nextCol);
        }
        return;
    }

    int[][] getNearby(int row, int col) {
        int[][] addedNumber = {{0,-1},{0,1},{-1,0},{1,0}};
        int[][] nearbyNode = new int[4][2] ;
        for (int i = 0; i < 4; i++) {
            nearbyNode[i][0] = addedNumber[i][0] + row;
            nearbyNode[i][1] = addedNumber[i][1] + col;
        }
        return nearbyNode;
    }
}
