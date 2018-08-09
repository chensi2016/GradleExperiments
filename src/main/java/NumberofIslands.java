public class NumberofIslands {
    char[][] grid;
    int length;
    int[] islands;
    int numberofIslands;
    int numberofConnected;

    public int numIslands(char[][] grid) {
        //islands = new ArrayList<>();
        this.grid = grid;
        if (grid.length == 0) {
            return 0;
        }
        this.length = grid.length*grid[0].length;
        islands = new int[length];
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[i].length; j++ ) {
                int nodeIndex = i*grid[0].length + j;
                if ( grid[i][j] == '1' ) {
                    if (nearIsland(nodeIndex) == null ){
                        numberofIslands++;
                        islands[nodeIndex] = numberofIslands;
                    } else {
                        islands[nodeIndex] = nearIsland(nodeIndex);
                        update(nodeIndex);

                    }
                } else {
                    continue;
                }
            }

        }
        return numberofIslands - numberofConnected;

    }
    Integer nearIsland(int nodeIndex) {
        int[] nearbyNode = getNearby(nodeIndex);

        for ( int i = 0 ; i < 4 ;i++ ) {
            if ( islands[nearbyNode[i]] != 0 ) {
            return islands[nearbyNode[i]];
            } else {
                continue;
            }

        }
        return null;
    }
    int[] getNearby(int nodeIndex) {
        int[] nearbyNode = new int[4] ;
        if (nodeIndex%grid[0].length != 0 ) {
            nearbyNode[0] = nodeIndex - 1;
        } else {
            nearbyNode[0] = nodeIndex;
        }

        if (nodeIndex%grid[0].length != grid[0].length - 1 ) {
            nearbyNode[1] = nodeIndex + 1;
        }else {
            nearbyNode[1] = nodeIndex;
        }

        if (nodeIndex > grid[0].length - 1 ) {

            nearbyNode[2] = nodeIndex - grid[0].length;
        }else {
            nearbyNode[2] = nodeIndex;
        }

        if (nodeIndex / grid[0].length != grid.length -1 ) {
            nearbyNode[3] = nodeIndex + grid[0].length;
        }else {
            nearbyNode[3] = nodeIndex;
        }
        return nearbyNode;
    }
    void update(int nodeIndex) {
        int[] nearbyNode = getNearby(nodeIndex);
        for( int i = 0 ; i < 4 ;i++ ) {
            if ( islands[nearbyNode[i]] != 0) {
                if (islands[nodeIndex] != islands[nearbyNode[i]] ){
                    numberofConnected++;
                    int newIslandIndex = islands[nodeIndex] < islands[nearbyNode[i]]? islands[nodeIndex]:islands[nearbyNode[i]];
                    int oldIslandIndex = islands[nodeIndex] < islands[nearbyNode[i]]? islands[nearbyNode[i]]:islands[nodeIndex];
                    for (int j = 0; j < length; j++) {
                        if (islands[j] == oldIslandIndex) {
                            islands[j] = newIslandIndex;
                        }
                    }
                }
            }
        }
    }
}
