import org.junit.Test;

import static org.junit.Assert.*;

public class NumberofIslandsTest {
    NumberofIslandsDFS numberofIslands = new NumberofIslandsDFS();
    char[][] grid = {{'1','1','1','1','1','1'},{'1','0','0','0','0','1'},{'1','0','1','1','0','1'},{'1','0','0','0','0','0','1'},{'1','1','1','1','1','1'}};
    //char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
    //char[][] grid = {{'1'},{'1'}};

    @Test
    public void numIslands() {
        assertEquals(2, numberofIslands.numIslands(grid));
        return;


    }
}