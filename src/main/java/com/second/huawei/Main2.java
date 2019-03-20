package com.second.huawei;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 笔试第二题：寻找蛇形字符串
 * 使用hashmap分别存储大写字符和小写字符
 * @author yangkuan
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        List<String> results = findPythonString(s);
        if(results.size()==0){
            System.out.println("Not Found");
        }else {
            for(String result:results){
                System.out.println(result);
            }
        }
    }

    public static List<String> findPythonString(String s){
        HashMap<Character,Integer> lowMap = new HashMap<>();
        HashMap<Character,Integer> bigMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch<='z'&&ch>='a'){
                lowMap.put(ch,lowMap.getOrDefault(ch,0)+1);
            }
            else if(ch<='Z'&&ch>='A'){
                bigMap.put(ch,bigMap.getOrDefault(ch,0)+1);
            }
        }
        List<String> list = new ArrayList<>();
        while (!bigMap.isEmpty()){
            for(char ch='A';ch<='Z';ch++){
                if(bigMap.containsKey(ch)&&lowMap.containsKey(Character.toLowerCase(ch))){
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    sb.append(Character.toLowerCase(ch));
                    bigMap.put(ch,bigMap.get(ch)-1);
                    lowMap.put(Character.toLowerCase(ch),lowMap.get(Character.toLowerCase(ch))-1);
                    if(bigMap.get(ch)==0) bigMap.remove(ch);
                    if(lowMap.get(Character.toLowerCase(ch))==0) lowMap.remove(Character.toLowerCase(ch));
                    goAhead(sb,lowMap,bigMap);
                    list.add(sb.toString());
                    break;
                }
                else if(bigMap.containsKey(ch)){
                    bigMap.remove(ch);
                }
                else if(lowMap.containsKey(Character.toLowerCase(ch))){
                    lowMap.remove(Character.toLowerCase(ch));
                }

            }
        }
        return list;
    }
    private static void goAhead(StringBuilder sb
            ,HashMap<Character,Integer> lowMap
            ,HashMap<Character,Integer> bigMap){
        char slowCh = (char) (sb.charAt(sb.length()-1)+1);
        char bigCh = Character.toUpperCase(slowCh);
        if(bigMap.containsKey(bigCh)&&lowMap.containsKey(slowCh)){
            sb.append(bigCh);
            sb.append(slowCh);
            bigMap.put(bigCh,bigMap.get(bigCh)-1);
            lowMap.put(slowCh,lowMap.get(slowCh)-1);
            if(bigMap.get(bigCh)==0) bigMap.remove(bigCh);
            if(lowMap.get(slowCh)==0) lowMap.remove(slowCh);
            goAhead(sb,lowMap,bigMap);
        }
        else if(bigMap.containsKey(bigCh)){
            bigMap.remove(bigCh);
        }
        else if(lowMap.containsKey(slowCh)){
            lowMap.remove(slowCh);
        }
    }
}
