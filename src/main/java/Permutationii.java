import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutationii {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        creatPermutation(nums, result, new ArrayList<>(), new boolean[nums.length] );
        return result;


    }
    void creatPermutation(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        if ( temp.size() == nums.length ) {
            result.add(new ArrayList<>(temp));
        } else {
            for ( int i = 0; i < nums.length; i++ ) {
                if ( used[i] || ( i > 0 && nums[i] == nums[i-1] && !used[i-1]) ) {
                    continue;
                } else {
                    temp.add(nums[i]);
                    used[i] = true;
                    creatPermutation(nums, result, temp, used);
                    used[i] = false;
                    temp.remove(temp.size()-1);

                }
            }
        }


    }
}
