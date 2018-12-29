package com.second.chapter6.interviewquestion40;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *
 * @author yangkuan
 */
public class Solution {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //异或操作
        int r = 0;
        for (int i = 0; i < array.length; i++) {
            r ^= array[i];
        }
        // 获取出现1的位数 1011 ,position=0
        int position = getFirst1Position(r);

        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < array.length; i++) {
            if(is1InPosition(array[i],position)){
                number1 ^=array[i];
            }else {
                number2 ^=array[i];
            }
        }
        num1[0]=number1;
        num2[0]=number2;
    }

    private int getFirst1Position(int r) {
        int i = 0;
        while ((r&1) != 1) {
            i++;
            r = r >> 1;
        }
        return i;
    }

    private boolean is1InPosition(int number, int position) {
        number = number >> position;
        boolean flag = true;
        if ((number&1) != 1) {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] array = {2,3,6,3,2,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Solution().FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }
}
