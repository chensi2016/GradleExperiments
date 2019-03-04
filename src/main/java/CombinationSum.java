import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, candidates.length-1, new ArrayList<>(), result);
        return result;
    }
    void helper(int[] candidates, int target, int end, List<Integer> path, List<List<Integer>> result) {
        if( target == 0 ) {
            result.add(new ArrayList<>(path));
            return;
        }
        if ( target < 0 ) {
            return;
        }
        for ( int i = end; i >= 0; i--) {
            if( i < end && candidates[i] == candidates[i + 1] ) {
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, target-candidates[i], i-1, path, result);
            path.remove(path.size()-1);
        }
    }
}
