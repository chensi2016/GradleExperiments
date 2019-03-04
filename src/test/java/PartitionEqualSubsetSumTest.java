import org.junit.Test;

        import static org.junit.Assert.*;

public class PartitionEqualSubsetSumTest {
    PartitionEqualSubsetSumRewrite partitionEqualSubsetSum = new PartitionEqualSubsetSumRewrite();

    @Test
    public void canPartition() {
        int[] nums = {2,2,3,5};
        assertEquals(false, partitionEqualSubsetSum.canPartition(nums));
    }
}