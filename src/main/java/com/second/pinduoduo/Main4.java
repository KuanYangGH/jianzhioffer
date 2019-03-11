package com.second.pinduoduo;

import java.util.Scanner;
import java.util.Stack;

/**
 * 拼多多服务端研发实习生，2019年3月10日笔试，笔试题4，统计两个括号串合并后的合法情况数量
 * 两个括号串，合并之后，判断合法括号串的数量
 * 主要分为两个步骤：
 * 1. 查找所有的括号串合并情况（使用递归方法）
 * 2. 判断合并串是否合法（使用栈）
 */
public class Main4 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s = "";
        merge(s,s1,0,s2,0);
        System.out.println(count);
    }

    private static void merge(String s, String s1, int index1, String s2, int index2) {
        if (index1 == s1.length() && index2 == s2.length()) {
            // 判断合并串是否合法
            if(isMatched(s)){
                count++;
                count = count%1000000007;
            }
        }
        if(index1 < s1.length()){
            StringBuilder ms1 = new StringBuilder(s+s1.charAt(index1));
            merge(ms1.toString(),s1,index1+1,s2,index2);
        }
       if(index2<s2.length()){
           StringBuilder ms2 = new StringBuilder(s+s2.charAt(index2));
           merge(ms2.toString(),s1,index1,s2,index2+1);
       }
    }

    /**
     * 判断合并串是否合法
     * @param s
     * @return
     */
    private static boolean isMatched(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    flag = false;
                    break;
                } else {
                    char c = stack.peek();
                    if (c == '(' && ch == ')') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (stack.size() != 0) flag = false;
        return flag;
    }
}
