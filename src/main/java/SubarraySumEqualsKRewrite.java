import java.util.HashMap;
import java.util.Map;
class endAndNumber{
    int end;
    int number;
    endAndNumber(int end, int number) {
        this.end = end;
        this.number = number;
    }
}
public class SubarraySumEqualsKRewrite {
    Map<endAndNumber, Integer> map = new HashMap<>();

    public int subarraySum( int[] nums, int k ) {
        int result = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            result = result + check( nums, i, k) ;
        }
        return result;
    }
    int check(int[] nums, int end, int number) {
        endAndNumber pair = new endAndNumber(end, number);
        if ( map.containsKey( pair ) ) {
            return map.get( pair );
        }
       int result = 0;
       if ( end == 0) {
           if ( nums[end] == number ) {
               result++;
           }
       } else{
        if ( nums[end] == number ) {
           result = check(nums, end - 1, number - nums[end]) + 1 ;
        } else {
           result = check(nums, end - 1, number - nums[end]);
            }
       }
       map.put( pair, result);
       return result;
    }
}
