package com.second.chapter4.interviewquestion28;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author yangkuan
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str==null){
            return result;
        }
        result.addAll(Permutation(str,0));
        return result;
    }

    private TreeSet<String> Permutation(String str, int beginIndex) {
        TreeSet<String> treeSet = new TreeSet<>();
        if (beginIndex == (str.length() - 1)) {
            treeSet.add(str);
            return treeSet;
        }
        for (int i = beginIndex; i < str.length(); i++) {
            String s = swap(str, beginIndex, i);
            treeSet.addAll(Permutation(s, beginIndex + 1));
        }
        return treeSet;
    }

    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> strings  = new Solution().Permutation(s);
        for (String string:strings){
            System.out.println(string);
        }
    }
}
