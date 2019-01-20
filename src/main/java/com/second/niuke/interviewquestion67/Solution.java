package com.second.niuke.interviewquestion67;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author yangkuan
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return movingCount(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCount(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= rows
                || j < 0 || j >= cols
                || calculateDigitSum(i) + calculateDigitSum(j) > threshold
                || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int upper = movingCount(threshold, rows, cols, i - 1, j, visited);
        int down = movingCount(threshold, rows, cols, i + 1, j, visited);
        int left = movingCount(threshold, rows, cols, i, j - 1, visited);
        int right = movingCount(threshold, rows, cols, i, j + 1, visited);
        return 1+upper+down+left+right;
    }

    private int calculateDigitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.print(new Solution().movingCount(15, 20, 20));
    }
}
