package com.second.interviewquestion32;

import java.util.Stack;

/**
 * 整数中1出现的次数
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * @author yangkuan
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0) {
            return 0;
        }
        // 获取数字每一位
        Stack<Integer> numbers = getNumber(n);
        // for example, 2345
        return NumberOf1Between1AndN(n, numbers);
    }

    public int NumberOf1Between1AndN(int n, Stack<Integer> numbers) {
        if (numbers.size() == 1 && numbers.peek() == 0) {
            return 0;
        }
        if (numbers.size() == 1 && numbers.peek() > 0) {
            return 1;
        }
        // for example, 2345
        int cnt = 0;
        // number = 2
        int number = numbers.pop();
        int nextN = n - number * pow(numbers.size());
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            cnt += nextN + 1 + numbers.size() * pow(numbers.size() - 1);
        } else {
            cnt += pow(numbers.size()) + numbers.size() * number * pow(numbers.size() - 1);
        }
        return cnt + NumberOf1Between1AndN(nextN, numbers);
    }

    private int pow(int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return pow(n / 2) * pow(n / 2);
        } else {
            return pow(n / 2) * pow(n / 2) * 10;
        }
    }

    /**
     * 统计数n的每一位
     *
     * @return
     */
    private Stack<Integer> getNumber(int n) {
        Stack<Integer> numbers = new Stack<>();
        while (n != 0) {
            numbers.push(n % 10);
            n = n / 10;
        }
        return numbers;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1Between1AndN_Solution(10000));
    }
}
