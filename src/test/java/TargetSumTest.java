import org.junit.Test;

import static org.junit.Assert.*;

public class TargetSumTest {
    TargetSum targetSum = new TargetSum();

    @Test
    public void findTargetSumWays() {
        int[] nums = {1};
        assertEquals(0, targetSum.findTargetSumWays(nums,2));
    }
}