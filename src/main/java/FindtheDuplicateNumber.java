import java.util.LinkedList;
import java.util.List;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int result = 0;
        int n = nums.length;
        int[] bukets = new int[n-1];
        for (int i = 0; i < n; i++) {
            bukets[nums[i]-1]++;
        }
        for(int i =0; i < n-1; i++) {
            if(bukets[i] > 1) {
                result = i + 1;
            }
            break;
        }
        return result;
    }
}
