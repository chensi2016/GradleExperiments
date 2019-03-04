import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubset(nums, new ArrayList<>(), result, 0);
        return result;
    }
    void findSubset(int[] nums, List<Integer> temp, List<List<Integer>> result, int current) {
        if ( current <= nums.length ) {
            result.add(new ArrayList<>(temp));
        } else{
            return;
        }
        for ( int i = current; i < nums.length; i++ ) {
            temp.add(nums[i]);
            findSubset(nums, temp, result, i + 1);
            temp.remove(temp.size()-1);
        }

    }
}
