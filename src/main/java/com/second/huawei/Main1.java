package com.second.huawei;

import java.util.Scanner;
/**
 * 100以内的加减法
 * 实例 输入：“12+3-5” ，输出：10
 * @author yangkuan
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(computeResult(s));
    }

    public static int computeResult(String s) {

        String[] splits = s.split("\\+|-");
        boolean[] flag = new boolean[splits.length - 1];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                flag[k++] = true;
            } else if (s.charAt(i) == '-') {
                flag[k++] = false;
            }
        }
        int result = Integer.valueOf(splits[0]);
        for (int i = 1; i < splits.length; i++) {
            if (flag[i - 1] == true) {
                result += Integer.valueOf(splits[i]);
            } else {
                result -= Integer.valueOf(splits[i]);
            }
        }
        return result;
    }
}
