
import java.util.ArrayList;

public class NumberofIslands {
    char[][] grid;
    ArrayList<ArrayList<Integer>> islands;

    public int numIslands(char[][] grid) {
        islands = new ArrayList<>();
        this.grid = grid;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[i].length; j++ ) {
                int nodeIndex = i*grid[0].length + j;
                if ( grid[i][j] == '1' ) {
                    if (nearIsland(nodeIndex) == null ){
                        ArrayList island = new ArrayList();
                        island.add(nodeIndex);
                        islands.add(island);
                    } else {
                        islands.get(nearIsland(nodeIndex)).add(nodeIndex);
                        update(nodeIndex);

                    }
                } else {
                    continue;

                }
            }

        }
        return islands.size();

    }
    Integer insideIslands(int nodeIndex) {
        for ( int i = 0; i< islands.size(); i++)
        {
            for ( int j=0; j<islands.get(i).size(); j++)
                if ( nodeIndex != islands.get(i).get(j)) {
                continue;
                } else {
                return i;
                }
        }
        return null;
    }
    Integer nearIsland(int nodeIndex) {
        int[] nearbyNode = getNearby(nodeIndex);

        if (nodeIndex / grid[0].length != grid.length -1 ) {
            nearbyNode[3] = nodeIndex + grid.length;
        }else {
            nearbyNode[3] = nodeIndex;
        }

        for ( int i = 0 ; i < 4 ;i++ ) {
            if ( insideIslands(nearbyNode[i]) != null ) {
            return insideIslands(nearbyNode[i]);
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
            nearbyNode[3] = nodeIndex + grid.length;
        }else {
            nearbyNode[3] = nodeIndex;
        }
        return nearbyNode;
    }
    void update(int nodeIndex) {
        int[] nearbyNode = getNearby(nodeIndex);
        for( int i = 0 ; i < 4 ;i++ ) {
            if ( insideIslands(nearbyNode[i]) != null) {
                if (insideIslands(nodeIndex) != insideIslands(nearbyNode[i])) {
                    int oldIslandIndex = insideIslands(nearbyNode[i]);
                    islands.get(insideIslands(nodeIndex)).addAll(islands.get(oldIslandIndex));
                    islands.remove(oldIslandIndex);


                }
            }
        }



    }
}
