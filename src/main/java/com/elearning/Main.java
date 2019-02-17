package com.elearning;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] v = new int[N];
        for (int i = 0; i < N; ++i)
            v[i] = sc.nextInt();
        int start = 0;
        int zeronum = 0;
        int ans = 0;
        for (int i = 0; i < N; ++i)
        {
            if (v[i] == 0)
            {
                if (zeronum < K)
                {
                    zeronum++;
                }
                else
                {
                    while (start < i && v[start] != 0) // skip ones
                    {
                        ++start;
                    }
                    start++; // skip leading zero
                }
            }
            ans = Math.max(ans, i - start + 1);
        }
        System.out.println(ans);
    }
}