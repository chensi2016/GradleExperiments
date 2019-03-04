import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] array = new int[n+1];
        Arrays.fill(array, Integer.MAX_VALUE);
        array[0] = 0;

        for(int i = 1; i <= n; i++) {
            int k = 1;
            while(i-k*k >= 0) {
                array[i] = Math.min(array[i], array[i-k*k]+1);
                k++;
            }
            }
        return array[n];
    }
}
