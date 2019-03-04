public class PartitionEqualSubsetSumByMemoArray {
    public boolean canPartition(int[] nums){
        int n = nums.length;
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if( sum % 2 == 1){
            return false;
        }
        int targetSum = sum/2;
        boolean[] dp = new boolean[targetSum+1];
        dp[0] = true;
        for(int i = 0; i < n; i++){
            for(int j = targetSum; j >=nums[i]; j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[targetSum];
    }
}
