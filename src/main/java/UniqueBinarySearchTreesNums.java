import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTreesNums {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if( n < 0 ) {
            return 0;
        }
        return helper(n, map);
    }
    int helper(int n, Map<Integer, Integer> map){
        int result = 0;
        if ( n == 0 ) {
            result = 1;
        }
        for ( int i = 1; i <= n; i++ ){
            int left = map.containsKey(i-1)? map.get(i-1):helper(i-1 , map);
            int right = map.containsKey(n-i) ? map.get(n-i):helper(n-i, map);
            map.putIfAbsent(i-1, left);
            map.putIfAbsent(n-i, right);
            result += left* right;
        }
        return result;
    }
}
