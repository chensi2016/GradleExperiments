public class SubarraySumEqualsKRewrite {
    //int[][] checkResult;

    public int subarraySum( int[] nums, int k ) {
       // checkResult = new int[nums.length][k];
        int result = 0;
        if(nums[0] == k)
            result++;
        for ( int i = 1; i < nums.length; i++ ) {
            if ( check( nums, i-1, k-nums[i]) ) {
                result++;
            }
        }
        return result;
    }
    boolean check(int[] nums, int end, int number) {
       /* if(checkResult[end][number] == 1) {
            return true;
        }
        if( checkResult[end][number] == -1) {
            return false;
        }*/
        if(number == 0) {
           // checkResult[end][number] = 1;
            return true;
        }
        if(end == 0) {
            if (nums[end] == number) {
               // checkResult[end][number] = 1;
                return true;
            }else {
              //  checkResult[end][number] = -1;
                return false;
            }

        }

        if ( end >= 1 && check(nums, end-1, number-nums[end]) ) {
            //checkResult[end][number] = 1;
            return true;
        }else {
           // checkResult[end][number] = -1;
            return false;
        }

    }
}
