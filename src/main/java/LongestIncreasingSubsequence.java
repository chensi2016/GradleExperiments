import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int tailArrayEnd = 0;
        for(int i = 0; i < nums.length; i++){
            int j = Arrays.binarySearch(tail,0,tailArrayEnd,nums[i]);
            if(j < 0){
                j = -(j+1);
            }
            tail[j] =nums[i];
            if(j == tailArrayEnd) {
                tailArrayEnd++;
            }

        }
        return tailArrayEnd;
    }
}
