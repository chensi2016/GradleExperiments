import org.junit.Test;

import static org.junit.Assert.*;

public class SubarraySumEqualsKTest {
    SubarraySumEqualsKRewrite test = new SubarraySumEqualsKRewrite();
    int[] nums = {0,0,0,0,0,0,0,0,0,0};

    @Test
    public void subarraySum() {
        assertEquals(55, test.subarraySum(nums,0));

    }
}