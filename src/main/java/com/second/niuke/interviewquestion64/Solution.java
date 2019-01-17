package com.second.niuke.interviewquestion64;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author yangkuan
 */
public class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);

    public void Insert(Integer num) {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        // insert max heap
        if ((minSize + maxSize) % 2 == 0) {
           minHeap.add(num);
           maxHeap.add(minHeap.poll());
        }
        // insert min heap
        else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            return 0.0;
        } else if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        } else {
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Insert(5);
        solution.Insert(2);
        solution.Insert(3);
        System.out.print(solution.GetMedian());
    }
}
