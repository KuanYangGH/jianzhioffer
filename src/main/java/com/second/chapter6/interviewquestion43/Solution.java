package com.second.chapter6.interviewquestion43;


/**
 * 面试题43：n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上的一面点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 *
 * @author yangkuan
 */
public class Solution {
    public void PrintProbability(int number) {
        int maxValue = 6;
        int[][] probability = new int[2][number * maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            probability[0][i] = 1;
            probability[1][i] = 1;
        }
        int flag = 0;
        for (int i = 2; i <= number; i++) {
            for (int j = 1; j <= number * maxValue; j++) {
                int sum = 0;
                for (int k = j - 6 > 0 ? j - 6 : 1; k < j && k <= number * maxValue; k++) {
                    sum += probability[flag][k];
                }
                probability[1 - flag][j] = sum;
            }
            flag = 1 - flag;
        }
        double total = Math.pow(maxValue,number);
        for(int i=number;i<=number * maxValue;i++){
            System.out.print((double) probability[flag][i]/total+" ");
        }
    }

    public static void main(String[] args) {
        new Solution().PrintProbability(3);
    }
}
