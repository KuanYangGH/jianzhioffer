package com.elearning.chapter4.interviewquestion28;

import com.elearning.chapter4.interviewquestion27.TreeNode;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 面试题28：字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @author yangkuan
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        int beginIndex = 0;
        TreeSet<String> tmp = recursive(str,beginIndex);
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(tmp);
        return result;
    }
    public TreeSet<String> recursive(String str,int beginIndex){
        TreeSet<String> strings = new TreeSet<>();
        if(beginIndex==str.length()-1){
            strings.add(str);
            return strings;
        }
        for(int i=beginIndex;i<str.length();i++){
            String newStr = swap(str,beginIndex,i);
            //strings.add(newStr);
            strings.addAll(recursive(newStr,beginIndex+1));
        }
        return strings;
    }
    public String swap(String str,int beginIndex,int endIndex){
        char[] chars = str.toCharArray();
        char ch = chars[beginIndex];
        chars[beginIndex] = chars[endIndex];
        chars[endIndex] = ch;
        String newStr = new String(chars);
        return newStr;
    }

    public static void main(String[] args) {
        String str = new String("abc");
        ArrayList<String> strings = new Solution().Permutation(str);
        for(String s:strings){
            System.out.println(s);
        }
    }
}
