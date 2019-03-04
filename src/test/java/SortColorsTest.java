import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {
    SortColorsOnePass sortColors = new SortColorsOnePass();

    @Test
    public void sortColors() {
        int[] nums = {0,0,1,0,1,1};
        sortColors.sortColors(nums);
        assertEquals(6, nums.length);
    }
}