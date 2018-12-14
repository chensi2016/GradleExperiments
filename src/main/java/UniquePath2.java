public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] pathNumber = new int[m][n];
        for (int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++) {
                if ( i == 0 && j== 0 ) {
                    if ( obstacleGrid[i][j] != 1  ) {
                        pathNumber[i][j] = 1;
                    }
                } else {
                    if ( obstacleGrid[i][j] != 1) {
                        int left = 0;
                        int up = 0;
                        if ( j != 0 ) {
                            left = pathNumber[i][j - 1];
                        }
                        if ( i != 0 ) {
                            up = pathNumber[i - 1][j];
                        }
                        pathNumber[i][j] = left + up;
                    }
                }
            }
        }
        return pathNumber[m-1][n-1];
    }
}
