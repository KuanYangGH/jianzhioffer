package com.second.chapter6.interviewquestion42_1;

/**
 * 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution {
    public String ReverseSentence(String str) {
        if(str==null||str.equals("")){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length-1);
        int begin = 0;
        int end = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                end = i;
                reverse(chars,begin,end-1);
                begin = end+1;
            }
        }
        reverse(chars,begin,chars.length-1);
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
        String s = "Hello World";
        System.out.println(new Solution().ReverseSentence(s));
    }
}
