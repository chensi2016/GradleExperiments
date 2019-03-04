
public class BestTimeBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1) {
            return 0;
        }
        int[][] graph = new int[n-1][n];
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if ( prices[j] > prices[i] ) {
                    graph[i][j] = prices[j] - prices[i];
                }
            }
        }
        int bestProfit = 0;
        bestProfit = search(graph, n, 0, 0, 0);
        return bestProfit;

    }
    int search(int[][] graph, int n, int profit, int bestProfit, int rowNum) {
        if ( rowNum >= n-1 ) {
            if( profit > bestProfit ){
                return profit;
            }
            return bestProfit;
        }
        for(int j = rowNum; j < n-1; j++ ) {
            for (int i = j + 1; i < n; i++) {
                int newProfit = profit;
                if (graph[j][i] != 0) {
                    newProfit += graph[j][i];
                    bestProfit = search(graph, n, newProfit, bestProfit, i + 2);
                }
            }
            if( profit > bestProfit ){
               bestProfit = profit;
            }
        }
        return bestProfit;
    }
}
