package com.second.chapter6.interviewquestion42;

/**
 * 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author yangkuan
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str==null||str.equals("")){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length-1);
        reverse(chars,0,chars.length-n-1);
        reverse(chars,chars.length-n,chars.length-1);
        return String.valueOf(chars);
    }
    private void reverse(char[] chars,int beginIndex,int endIndex){
        while (beginIndex<endIndex){
            char tmp = chars[beginIndex];
            chars[beginIndex] = chars[endIndex];
            chars[endIndex] = tmp;
            beginIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        String s = "abcXYZdef";
        System.out.println(new Solution().LeftRotateString(s,3));
    }
}
