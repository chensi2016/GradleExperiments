import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class endAndNumber{
    int end;
    int number;
    endAndNumber(int end, int number) {
        this.end = end;
        this.number = number;
    }
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof endAndNumber)) {
            return false;
        }
        endAndNumber eAN = (endAndNumber) o;
        return end == eAN.end && number == eAN.number;

    }
    public int hashCode() {
        return Objects.hash( end, number );
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
        if( end == -1 ) {
            return result;
        }
        if ( nums[end] == number ) {
           result = check(nums, end - 1, number - nums[end]) + 1 ;
        } else {
           result = check(nums, end - 1, number - nums[end]);
        }
       map.put( pair, result);
       return result;
    }
}
