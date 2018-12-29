package com.second.chapter5.interviewquestion35;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35：第一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * @author yangkuan
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] characters = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : characters) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        for (; i < characters.length; i++) {
            if (map.get(characters[i]) == 1) {
                break;
            }
        }
        return i == characters.length ? -1 : i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().FirstNotRepeatingChar("sshdahah"));
    }
}
