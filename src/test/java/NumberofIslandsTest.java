import org.junit.Test;

import static org.junit.Assert.*;

public class NumberofIslandsTest {
    NumberofIslands numberofIslands = new NumberofIslands();
   // char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};





    @Test
    public void numIslands() {
        assertEquals(1, numberofIslands.numIslands(grid));
        return;


    }
}