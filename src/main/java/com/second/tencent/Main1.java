package com.second.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 腾讯提前批笔试题：从a出发，n个检查点到达n-1个点
 * @author yangkuan
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int[] x = new int[n];
        for(int i=0;i<n;i++){
            x[i] = scanner.nextInt();
        }
        Arrays.sort(x);
        int[] x1 = Arrays.copyOfRange(x,0,x.length-1);
        int[] x2 = Arrays.copyOfRange(x,1,x.length);

        int d1 = findMinDistance(x1,a);
        int d2 = findMinDistance(x2,a);
        System.out.println(Math.min(d1,d2));
    }

    private static int findMinDistance(int[] x, int a) {
        int min = 0;
        if (a < x[0]) {
            min = x[x.length - 1] - a;
        } else if (a > x[x.length - 1]) {
            min = a - x[0];
        }
        else {
            min = Math.min(x[x.length-1]-x[0]+a-x[0],x[x.length-1]-x[0]+x[x.length-1]-a);
        }
        return min;
    }
}
