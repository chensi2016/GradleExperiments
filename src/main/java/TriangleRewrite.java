import java.util.List;

public class TriangleRewrite {
    public int minimumTotal(List<List<Integer>> triangle){
        int[] dp = new int[triangle.size()];
        if ( triangle.size() > 1) {
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}
