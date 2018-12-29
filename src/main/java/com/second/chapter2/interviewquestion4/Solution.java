package com.second.chapter2.interviewquestion4;


/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author yangkuan
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return str.toString();
        }
        int len = str.length();
        //计算空格数
        int blanks = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                blanks++;
            }
        }
        int newLen = len + 2 * blanks;
        //添加任意字符，至新长度
        for(int i=len;i<newLen;i++){
            str.append("#");
        }
        int left = len - 1, right = newLen - 1;
        while (left != right) {
            if(str.charAt(left)==' '){
                str.setCharAt(right,'0');
                str.setCharAt(right-1,'2');
                str.setCharAt(right-2,'%');
                right -= 3;
            }
            else {
                str.setCharAt(right,str.charAt(left));
                right--;
            }
            left--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello world ");
        System.out.print(new Solution().replaceSpace(str));
    }
}
