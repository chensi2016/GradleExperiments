import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int previous = 0;
        Arrays.sort(nums);
        for (int n : nums) {
            if ( result.isEmpty() ) {
                List<Integer> list = new LinkedList<>();
                list.add(n);
                result.add(list);
                previous = n;
            } else {
                List<List<Integer>> temp = new LinkedList<>();
                for ( List<Integer> exitList : result ) {
                    for ( int i = 0; i <= exitList.size(); i++) {
                        if ( n == previous && i > 0 && exitList.get(i - 1) == n) {
                            continue;
                        }
                        List<Integer> list = new LinkedList<>(exitList);
                        list.add(i, n);
                        temp.add(list);
                    }
                }
                result = temp;
                previous = n;
            }
        }
        return result;

    }
}
