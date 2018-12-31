package com.elearning.chapter6.interviewquestion43;

/**
 * 面试题43：n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上的一面点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 * @author yangkuan
 */
public class Solution {
    int value = 6;

    /**
     * 方法1：递归，重复计算带来时间效率低
     * @param number
     */
    public void PrintProbabilityFirstMethod(int number){
        if(number==0){
            return;
        }
        int maxValue = number*value;
        int len =  maxValue-number+1;
        int[] cnts = new int[len];
        for(int i=0;i<len;i++){
            cnts[i] = 0;
        }
        probability(number,cnts);
        print(number,cnts);
    }

    /**
     * 方法2：循环
     * @param number
     */
    public void PrintProbabilitySecondMethod(int number){
        if(number==0){
            return;
        }
        int maxValue = number*value;
        int len =  maxValue;
        int[] lastCnts = new int[len];
        int[] currentCnts = new int[len];
        for(int i=0;i<len;i++){
            lastCnts[i] = 0;
            currentCnts[i] = 0;
        }
        //一个骰子
        for(int i=0;i<value;i++){
            currentCnts[i]++;
            lastCnts[i]++;
        }
        //增加骰子
        for(int i=1;i<number;i++){
            for(int j=1;j<maxValue;j++){
                if(j>=value){
                    int s = 0;
                    for(int k=j-value;k<=j-1;k++){
                        s += lastCnts[k];
                    }
                    currentCnts[j] = s;
                }
                else {
                    int s = 0;
                    for(int k=0;k<=j-1;k++){
                        s += lastCnts[k];
                    }
                    currentCnts[j] = s;
                }
            }
            for(int j=0;j<maxValue;j++){
                lastCnts[j] = currentCnts[j];
            }
        }
        double total = Math.pow(value,number);
        for(int i=number-1;i<maxValue;i++){
            System.out.print((i+1)+":");
            System.out.println((double) currentCnts[i]/total);
        }
    }

    private void probability(int number, int[] cnts){
        for(int i=1;i<=value;i++){
            probability(number,number,i,cnts);
        }
    }
    private void probability(int origin, int current, int sum, int[] cnts){
        if(current==1){
            cnts[sum-origin]++;
        }
        else {
            for(int i=1;i<=value;i++){
                probability(origin,current-1,sum+i,cnts);
            }
        }

    }
    private void print(int number, int[] cnts){
        double total = Math.pow(value,number);
        for(int i=0;i<cnts.length;i++){
            System.out.print((i+number)+":");
            System.out.println((double) cnts[i]/total);
        }
    }

    public static void main(String[] args) {
        new Solution().PrintProbabilityFirstMethod(3);
        new Solution().PrintProbabilitySecondMethod(3);
    }
}
