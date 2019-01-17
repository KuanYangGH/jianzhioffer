package com.second.niuke.interviewquestion65;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author yangkuan
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if(num==null||size==0){
            return result;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (queue.isEmpty()) {
                queue.add(i);
            } else {
                while (!queue.isEmpty() && num[queue.getLast()] < num[i]) {
                    queue.removeLast();
                }
                queue.add(i);
            }
            while ((queue.getLast() - queue.getFirst() + 1) > size) {
                queue.removeFirst();
            }
            if (i + 1 >= size) {
                result.add(num[queue.getFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.print(new Solution().maxInWindows(num, 3));
    }
}
