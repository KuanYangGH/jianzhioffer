package com.second.chapter3.interviewquestion11;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author yangkuan
 */
public class Solution {
    public double Power(double base, int exponent) {
        int negative = exponent < 0 ? -1 : 1;
        exponent *= negative;
        if (base == 0) {
            return 0;
        }
        double result = PowerWithUnsignedInt(base, exponent);

        if (negative == -1) {
            result = 1 / result;
        }
        return result;
    }

    private double PowerWithUnsignedInt(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent % 2 == 0) {
            return PowerWithUnsignedInt(base, exponent / 2)
                    * PowerWithUnsignedInt(base, exponent / 2);
        } else {
            return PowerWithUnsignedInt(base, exponent / 2)
                    * PowerWithUnsignedInt(base, exponent / 2) * base;
        }
    }

    public static void main(String[] args) {
        System.out.print(new Solution().Power(2.0, 6));
    }
}
