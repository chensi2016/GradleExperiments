public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum%2 == 1) {
            return false;
        }
        int n = nums.length;
        int m = n/2;
        for(int i = 1; i <= m; i++ ) {
            if(check(nums, -1,-1,i-1,0, sum/2)){
                return true;
            }
        }
        return false;
    }
    boolean check(int[] nums,int previousIndex, int currentN, int targetN,int currentSum, int targetSum){
        boolean result = false;
        if(currentN == targetN){
            if(currentSum == targetSum){
                return true;
            } else{
                return false;
            }
        }
        for(int i=previousIndex+1; i<nums.length;i++) {
            result = result || check(nums, i,currentN+1, targetN,currentSum + nums[i],targetSum);
            if(result == true){
                return true;
            }
        }
        return result;
    }

}
