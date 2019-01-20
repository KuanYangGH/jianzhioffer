package com.second.niuke.interviewquestion66;


/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 *
 * @author yangkuan
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null) {
            return false;
        }
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i * cols + j] == str[0]) {
                    visited[i][j] = true;
                    boolean flag = hasPath(matrix, rows, cols, str, 1, i + 1, j, visited)
                            || hasPath(matrix, rows, cols, str, 1, i, j + 1, visited)
                            || hasPath(matrix, rows, cols, str, 1, i - 1, j, visited)
                            || hasPath(matrix, rows, cols, str, 1, i, j - 1, visited);
                    visited[i][j] = false;
                    if(flag) return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, char[] str
            , int sIndex, int rowIndex, int colIndex, boolean[][] visited) {
        if (sIndex == str.length) {
            return true;
        }
        if (rowIndex >= 0
                && rowIndex < rows
                && colIndex >= 0
                && colIndex < cols
                && matrix[rowIndex * cols + colIndex] == str[sIndex]
                && !visited[rowIndex][colIndex]) {
            visited[rowIndex][colIndex] = true;
            boolean flag = hasPath(matrix, rows, cols, str, sIndex + 1, rowIndex + 1, colIndex, visited)
                    || hasPath(matrix, rows, cols, str, sIndex + 1, rowIndex - 1, colIndex, visited)
                    || hasPath(matrix, rows, cols, str, sIndex + 1, rowIndex, colIndex + 1, visited)
                    || hasPath(matrix, rows, cols, str, sIndex + 1, rowIndex, colIndex - 1, visited);
            if (flag == false) visited[rowIndex][colIndex] = false;
            return flag;
        }
        return false;
    }

    public static void main(String[] args) {
        String matrix = "ABCESFCSADEE";
        String str = "SEE";
        System.out.print(new Solution().hasPath(matrix.toCharArray(), 3, 4, str.toCharArray()));
    }
}
