public class MinimumPathSum {
    int[][] record;
    public int minPathSum(int[][] grid) {
        if ( grid.length <= 0 ) {
            return 0;
        }
        record = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                record[i][j] = -1;
            }
        }
        return findMinPathSum(grid, grid.length - 1 ,grid[0].length -1);

    }
    private int findMinPathSum(int[][] grid, int x, int y) {
        if( x == 0 && y == 0) {
            return grid[x][y];
        }
        if( x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1  ){
            return Integer.MAX_VALUE;
        }
       if ( record[x][y] != -1 ) {
            //System.out.println("I am in the record");
            return record[x][y];
        }

        int[][] diff = {{-1,0},{0,-1},{1,0},{0,1}};
       // int surroundSum;
        int minSurroundSum = Integer.MAX_VALUE;
       /* for (int i = 0; i < 2; i++) {
            int m = x + diff[i][0];
            int n = y + diff[i][1];
            if( m < 0 || m > grid.length - 1 || n < 0 || n > grid[0].length - 1  ){
                continue;
            }
            surroundSum = findMinPathSum(grid, m, n);
            if (surroundSum < minSurroundSum) {
                minSurroundSum = surroundSum;
            }
        }*/
        minSurroundSum = Math.min( findMinPathSum(grid, x-1, y), findMinPathSum(grid, x, y-1));
        record[x][y] = minSurroundSum + grid[x][y];
        return minSurroundSum + grid[x][y];

    }
}