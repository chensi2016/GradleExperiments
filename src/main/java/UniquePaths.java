public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[n + 1][m + 1];

        for( int i = 1; i < n + 1; i++ ) {
            for( int j = 1; j < m + 1; j++) {
                if( i == 1 && j==1 ) {
                    count[i][j] = 1;
                    continue;
                }
                count[i][j] = ( count[i-1][j] +  count[i][j-1]);
            }
        }
        return count[n][m];
    }
}
