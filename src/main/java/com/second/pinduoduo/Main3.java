package com.second.pinduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 拼多多服务端研发实习生，2019年3月10日笔试，笔试题3:两个小偷分别偷两个银行，怎样偷得最多的钱
 * 小偷之间距离必须大于d
 */
public class Main3 {
    public static class P {
        public int a;
        public long b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d = sc.nextLong();
        P[] p = new P[n];
        long[] mx = new long[n];
        for (int i = 0; i < n; ++i) {
            p[i] = new P();
            p[i].a = sc.nextInt();
            p[i].b = sc.nextLong();
        }
        Arrays.sort(p, new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return Integer.compare(o1.a, o2.a);
            }
        });
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0)
                mx[i] = Math.max(mx[i-1], p[i].b);
            else
                mx[i] = p[i].b;
            int j = -1;
            int l = 0, r = i-1;
            while (l <= r) {
                int mid = l + (r-l) / 2;
                if (p[mid].a <= p[i].a - d) {
                    j = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (j != -1)
                ans = Math.max(ans, mx[j] + p[i].b);
        }
        System.out.println(ans);
    }
}
