class Solution {
    public int maxProfit(int[] prices) {
        int maxGain=0;
        int minGain=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            minGain = Math.min(minGain, prices[i]);

            maxGain = Math.max(maxGain, prices[i] - minGain);
        }
        return maxGain;
    }
}
