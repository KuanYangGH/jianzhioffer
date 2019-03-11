
package com.second.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 拼多多服务端研发实习生，2019年3月10日笔试，笔试题1，两个数组调整顺序，以求得最小的点积
 * 两个数组进行排序，数组a的升序与b的降序进行点积
 * @author yangkuan
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = in.nextInt();
        }
        System.out.println(new Main1().minMultiplySum(a,b));
    }

    public int minMultiplySum(int[] a, int[] b) {
        int n = a.length;
        int min = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            min += a[i]*b[n-i-1];
        }
        return min;
    }
}
