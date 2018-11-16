import java.util.ArrayList;
import java.util.List;

public class SubarraySumEqualsK {
    public int subarraySum( int[] nums, int k ) {
        int result = 0;
        List<List<Integer>>  workingList = new ArrayList<>();
        for ( int i = 0; i < nums.length; i++ ) {
                List<Integer> newList = new ArrayList<>();
                newList.add(0);
                workingList.add(newList);
                for (List<Integer> list : workingList) {
                    int subSum = list.get(0) + nums[i];
                    list.add(nums[i]);
                    list.set(0, subSum);
                    if ( subSum == k ) {
                        result++;
                        }
                }
        }
    return result;
    }
}
