package com.second.chapter7.interviewquestion49;


/**
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * @author yangkuan
 */
public class Solution {
    public int StrToInt(String str) {
        int i = 0;
        int len = str.length();
        boolean negative = false;
        int result = 0;

        if (len > 0) {
            // contain +/-
            char firstChar = str.charAt(i);
            if (firstChar < '0') {
                if(firstChar=='-'){
                    negative = true;
                }
                else if(firstChar!='+'){
                    return 0;
                }
                i++;
            }
            while (i < len) {
                int digit = str.charAt(i++) - '0';
                if (digit > 9 || digit < 0) {
                    return 0;
                }
                result = result * 10 + digit;
            }
        }
        return negative?-result:result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().StrToInt("+23"));
    }
}
