import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationsTest {
    Permutationii permutations = new Permutationii();

    @Test
    public void permute() {
        int[] nums = {2,2,1,1};
        assertEquals(6, permutations.permuteUnique(nums).size());
    }
}