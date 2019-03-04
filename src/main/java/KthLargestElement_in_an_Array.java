import java.util.Arrays;

public class KthLargestElement_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int count = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            count++;
            if( count == k) {
                result = nums[k];
                break;
            }
        }
        return result;
    }
}
