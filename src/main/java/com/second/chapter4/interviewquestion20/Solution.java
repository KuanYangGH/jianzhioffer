package com.second.chapter4.interviewquestion20;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @author yangkuan
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int xStart = 0, yStart = 0;
        int xEnd = rows - 1 - xStart, yEnd = cols - 1 - yStart;
        while (xStart <= xEnd && yStart <= yEnd) {
            int i = xStart, j = yStart;
            //left to right
            for(;j<=yEnd;j++){
                result.add(matrix[i][j]);
            }
            //up to bottom
            for (i=xStart+1,j=yEnd;i<=xEnd;i++){
                result.add(matrix[i][j]);
            }
            //right to left
            if(xStart<xEnd){
                for (i=xEnd,j=yEnd-1;j>=yStart;j--){
                    result.add(matrix[i][j]);
                }
            }
            //bottom to up
            if(yStart<yEnd){
                for(i=xEnd-1,j=yStart;i>xStart;i--){
                    result.add(matrix[i][j]);
                }
            }
            xStart++;
            yStart++;
            xEnd = rows - 1 - xStart;
            yEnd = cols - 1 - yStart;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.print(new Solution().printMatrix(matrix));
    }
}
