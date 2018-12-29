package com.second.chapter5.interviewquestion33;

/**
 * 面试题33：把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @author yangkuan
 * @date 2018/12/22 17:13
 */
public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if(numbers==null||numbers.length==0){
            return new String();
        }
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        quickSort(strNumbers, 0, strNumbers.length - 1);
        String r = "";
        for (String s : strNumbers) {
            r += s;
        }
        return r;
    }

    private void quickSort(String[] numbers, int beginIndex, int endIndex) {
        int index = partition(numbers, beginIndex, endIndex);
        if (beginIndex < index-1) {
            quickSort(numbers, beginIndex, index-1);
        }
        if (index+1 < endIndex) {
            quickSort(numbers, index+1, endIndex);
        }
    }

    private int partition(String[] numbers, int beginIndex, int endIndex) {
        int i = beginIndex - 1;
        String x = numbers[endIndex];
        for (int j = beginIndex; j < endIndex; j++) {
            if (compare(numbers[j],x)) {
                i++;
                swap(numbers, i, j);
            }
        }
        swap(numbers, i + 1, endIndex);
        return i + 1;
    }

    private boolean compare(String s1,String s2){
        String string1 = s1+s2;
        String string2 = s2+s1;
        return string1.compareTo(string2)<0;
    }

    private void swap(String[] numbers, int i, int j) {
        String tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers = {321, 3, 32};
        System.out.println(new Solution().PrintMinNumber(numbers));
    }
}
