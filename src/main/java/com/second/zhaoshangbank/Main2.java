package com.second.zhaoshangbank;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        long number[]=new long[num];
        for(int i=0;i<num;i++){
            number[i]=scanner.nextInt();
        }
        System.out.println(getAnswer(number)) ;

    }

    public static long findMin(long[] number) {
        long min=number[0];
        for(int i=1;i<number.length;i++){
            if(number[i]<min){
                min=number[i];
            }
        }
        return min;

    }

    public static long findMax(long[] number) {
        long max=number[0];
        for(int i=1;i<number.length;i++){
            if(number[i]>max){
                max=number[i];
            }
        }
        return max;

    }

    public static long getAnswer(long[] number){
        if(number==null || number.length<=0){
            return -1;
        }
        if(number.length==1){
            return number[0];
        }
        long max=findMax(number);
        long min=findMin(number);

        if(min>=0){
            long sum=0;
            for(int i=0;i<number.length;i++){
                sum +=Math.abs(number[i]);
            }
            sum=sum-2*Math.abs(min);
            return sum;
        }else if(max<=0){
            long sum=0;
            for(int i=0;i<number.length;i++){
                sum +=Math.abs(number[i]);
            }
            sum=sum-2*Math.abs(max);
            return sum;

        }else{
            long sum=0;
            for(int i=0;i<number.length;i++){
                sum +=Math.abs(number[i]);
            }
            return sum;


        }
    }

}