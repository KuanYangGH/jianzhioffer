package com.elearning.niuke.interviewquestion67;

/**
 * 面试题67：机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author yangkuan
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows<=0||cols<=0){
            return 0;
        }
        int len = rows*cols;
        boolean[] isVisited = new boolean[len];
        for(int i=0;i<len;i++){
            isVisited[i]=false;
        }
        return movingCountCore(threshold,rows,cols,0,0,isVisited);

    }
    private int movingCountCore(int threshold, int rows, int cols, int curRow, int curCol, boolean[] isVisited){
        if(curCol>=cols||curRow>=rows
                ||curCol<0||curRow<0
                ||bitSum(curCol)+bitSum(curRow)>threshold||isVisited[curRow*cols+curCol]){
            return 0;
        }
        isVisited[curRow*cols+curCol] = true;
        return 1 + movingCountCore(threshold,rows,cols,curRow+1,curCol,isVisited)+
                movingCountCore(threshold,rows,cols,curRow,curCol+1,isVisited)+
                movingCountCore(threshold,rows,cols,curRow-1,curCol,isVisited)+
                movingCountCore(threshold,rows,cols,curRow,curCol+1,isVisited);
    }

    private int bitSum(int number){
        int sum = 0;
        while (number!=0){
            sum += number%10;
            number = number/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(15,20,20));
    }
}
