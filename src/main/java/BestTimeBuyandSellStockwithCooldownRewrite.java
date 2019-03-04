public class BestTimeBuyandSellStockwithCooldownRewrite {
    int maxProfit(int[] prices){
        int n = prices.length;
        if ( n <=1 ){
            return 0;
        }
        int[] profit = new int[n + 2];
        int[][] graph = new int[n-1][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ( prices[j] > prices[i] ) {
                    graph[i][j] = prices[j] - prices[i];
                }
            }
        }
        int bestProfit = 0;
        for(int i = n-2; i >= 0; i--) {
            for(int j = n - 1; j > i; j--) {
                if(graph[i][j] + profit[j+2] > profit[i] ) {
                    profit[i] = graph[i][j] + profit[j + 2];
                }

            }
            if( profit[i] < profit[i+1] ){
                profit[i] = profit[i+1];
            }
            if ( profit[i] > bestProfit ){
                bestProfit = profit[i];
            }

        }
        return bestProfit;

    }
}
