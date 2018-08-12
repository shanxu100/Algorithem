package nowcoder.DP;

/**
 * @author Guan
 * @date Created on 2018/8/12
 */
public class Stock {

    public static void main(String[] args) {
        int[] prices = new int[]{534, 237, 144, 542, 346};
        System.out.println(maxProfit(prices, 5));
        doJob(prices, 5);
    }

    public static void doJob(int[] prices, int n) {
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            int value1 = getDiffValue(prices, 0, i);
            int value2 = getDiffValue(prices, i + 1, n - 1);
            maxValue = Math.max(maxValue, value1 + value2);
        }
        System.out.println(maxValue);
    }

    public static int getDiffValue(int[] prices, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int value = 0;
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                value = Math.max(value, prices[i] - min);
            }
        }
        return value;
    }


    public static int maxProfit(int[] prices, int n) {
        int firstBuyProfit = Integer.MIN_VALUE;
        int firstSaleProfit = Integer.MIN_VALUE;
        int secondBuyProfit = Integer.MIN_VALUE;
        int secondSaleProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            firstBuyProfit = Math.max(firstBuyProfit, -prices[i]);
            firstSaleProfit = Math.max(firstSaleProfit, firstBuyProfit + prices[i]);
            secondBuyProfit = Math.max(secondBuyProfit, firstSaleProfit - prices[i]);
            secondSaleProfit = Math.max(secondSaleProfit, secondBuyProfit + prices[i]);
        }
        return secondSaleProfit;
    }
}
