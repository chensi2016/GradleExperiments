import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for ( int i = 1; i < nums.length - 1; i++ ) {
            result[i] = result[i-1] * nums[i];
        }

        result[nums.length -1] = result[nums.length - 2];
        int right =  nums[nums.length -1];
        for ( int j = nums.length - 2; j > 0; j-- )
        {
            result[j] = right * result[j-1];
            right *= nums[j];
        }
        result[0] = right;
        return result;
    }
}
