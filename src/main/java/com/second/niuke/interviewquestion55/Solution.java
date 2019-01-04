package com.second.niuke.interviewquestion55;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author yangkuan
 */
public class Solution {
    ArrayList<Character> characters = new ArrayList<>();
    Map<Character,Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        characters.add(ch);
        map.put(ch,map.getOrDefault(ch,0)+1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i=0;i<characters.size();i++){
            if(map.get(characters.get(i))==1){
                return characters.get(i);
            }
        }
        return '#';
    }
}
