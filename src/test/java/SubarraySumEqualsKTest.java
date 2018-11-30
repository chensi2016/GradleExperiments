import org.junit.Test;

import static org.junit.Assert.*;

public class SubarraySumEqualsKTest {
    SubarraySumEqualsKRewrite test = new SubarraySumEqualsKRewrite();
    int[] nums = {1,1,1};

    @Test
    public void subarraySum() {
        assertEquals(2, test.subarraySum(nums,2));

    }
}