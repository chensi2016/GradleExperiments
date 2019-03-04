import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeBuyandSellStockwithCooldownTest {

    @Test
    public void maxProfit() {
        BestTimeBuyandSellStockwithCooldownRewrite bestTimeBuyandSellStockwithCooldown = new BestTimeBuyandSellStockwithCooldownRewrite();
        int[] test = {2,1,4};
        assertEquals(3,bestTimeBuyandSellStockwithCooldown.maxProfit(test));

    }
}