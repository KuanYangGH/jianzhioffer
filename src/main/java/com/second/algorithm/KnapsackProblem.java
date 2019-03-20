package com.second.algorithm;

/**
 * 01背包问题
 * 给定一组物品，每种物品i都有自己的重量w[i]和价格v[i]，在限定的总重量内n，我们如何选择，才能使得物品的总价格最高。
 * @author yangkuan
 * @date 2019/03/19
 */
public class KnapsackProblem {
    public int KnapSack(int[] w,int[] v,int n){
        if(n<=0){
            return 0;
        }
        // 物品的个数
        int m = w.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                // 背包体积为0或没有物品
                if(j==0||i==0){
                    dp[i][j] = 0;
                }
                else if(j>=w[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] w = {2,2,6,5,4};
        int[] v = {6,3,5,4,6};
        System.out.println(new KnapsackProblem().KnapSack(w,v,10));
    }
}
