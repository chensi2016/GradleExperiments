import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSumRewrite {
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum%2 == 1) {
            return false;
        }
        int n = nums.length;
        int m = n/2;
        Set<Integer> possibleSum = new HashSet<>();
        possibleSum.add(0);
        for(int i = 0; i < n; i++){
            Set<Integer> copyPossibleSum = new HashSet<>(possibleSum);
            for(Integer x : copyPossibleSum){
                int newSum = x + nums[i];
                if(newSum == sum/2){
                    return true;
                }
                possibleSum.add(newSum);
            }
        }
        return false;
    }
}
