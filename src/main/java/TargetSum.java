public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i:nums) {
            sum+=i;
        }
        if (S > sum || S < -sum) return 0;
        int[][] dp = new int[nums.length][2*sum + 1];
        dp[0][nums[0]+sum] = 1;
        dp[0][-nums[0]+sum] = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = -sum + nums[nums.length-1]; j <= sum -nums[nums.length-1] ; j++ ){
                if(dp[i - 1][j + sum] != 0) {
                    dp[i][j + nums[i] + sum] += dp[i - 1][j + sum];
                    dp[i][j - nums[i] + sum] += dp[i - 1][j + sum];
                }
            }
        }
        if( -sum <= S && S <= sum)
            return dp[nums.length - 1][S + sum];
        else
            return 0;
    }
}
