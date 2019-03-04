import org.junit.Test;

import static org.junit.Assert.*;

public class QueueReconstructionbyHeightTest {
    QueueReconstructionbyHeight queueReconstructionbyHeight = new QueueReconstructionbyHeight();
    @Test
    public void reconstructQueue() {
        int[][] input = {{7,0},{4,2},{7,1},{5,0},{6,1},{5,2}};
        int[][] expected = {{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}};
        assertArrayEquals(expected, queueReconstructionbyHeight.reconstructQueue(input));
    }
}