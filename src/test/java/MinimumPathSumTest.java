import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumPathSumTest {
    MinimumPathSum minimumPathSum = new MinimumPathSum();
    int[][] grid = {{7,0,8,8,0,3,5,8,5,4},{4,1,2,9,9,6,0,8,6,9},{9,7,1,1,0,1,2,4,1,7}};

    @Test
    public void minPathSum() {
        assertEquals(27, minimumPathSum.minPathSum(grid));

    }
}