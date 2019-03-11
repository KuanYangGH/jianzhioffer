package com.second.pinduoduo;

import java.util.Scanner;

/**
 * 拼多多服务端研发实习生，2019年3月10日笔试，笔试题2,字母串中的按字母序的最小字母
 * @author yangkuan
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        char max = 'A';
        char min = 'z';
        for (int i = 0; i < n; i++) {
            max = max > s.charAt(i) ? max : s.charAt(i);
            min = min < s.charAt(i) ? min : s.charAt(i);
        }
        if (max <= 'Z' || min >= 'a') {
            // 只有大写字母或小写字母
            System.out.println(Character.toLowerCase(min));
        } else {
            System.out.println(getMinChar(s));
        }
    }

    /**
     * 既有大写字母又有小写字母，找到最小字母
     * @param string
     * @return
     */
    public static char getMinChar(String string) {
        int res = Integer.MAX_VALUE;
        for (int c : string.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = c + 32;
            }
            if (c < res) {
                res = c;
            }
        }
        return (char) res;
    }
}
