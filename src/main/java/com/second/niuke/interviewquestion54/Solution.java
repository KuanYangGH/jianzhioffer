package com.second.niuke.interviewquestion54;

/**
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author yangkuan
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        String[] strings = null;
        if (s.contains("E")) {
            strings = s.split("E");
        }
        if (s.contains("e")) {
            strings = s.split("e");
        }
        if (strings != null && strings.length != 2) {
            return false;
        }
        // no exponent
        if (strings == null) {
            return isDecimals(s);
        }
        return isDecimals(strings[0]) && isInteger(strings[1]);
    }

    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private boolean isInteger(String s) {
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        for (; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isDecimals(String s) {
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        int dots = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                dots++;
            }
            if (c != '.' && !isDigit(c)) {
                return false;
            }
        }
        if (dots > 1 || (s.contains(".") && s.charAt(s.length() - 1) == '.')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1.2.3";
        System.out.println(new Solution().isNumeric(s.toCharArray()));
    }
}
