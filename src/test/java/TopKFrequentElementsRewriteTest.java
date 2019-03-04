import org.junit.Test;

import static org.junit.Assert.*;

public class TopKFrequentElementsRewriteTest {
    TopKFrequentElementsRewrite topKFrequentElementsRewrite = new TopKFrequentElementsRewrite();
    @Test
    public void topKFrequent() {
        int[] nums = {1,1,1,2,2,3};
        int[] expect = {1,2};
        assertEquals( expect.length, topKFrequentElementsRewrite.topKFrequent(nums,2).size());
    }
}