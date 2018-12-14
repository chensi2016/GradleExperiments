import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @Test
    public void maxArea() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        assertEquals(49, containerWithMostWater.maxArea(height));
    }
}