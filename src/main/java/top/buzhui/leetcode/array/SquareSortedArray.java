package top.buzhui.leetcode.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/squares-of-a-sorted-array/">有序数组的平方</a>
 *
 * @author iyuhp created at 2020/10/16
 */
public class SquareSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-3, -1, 2, 4})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    private static int[] sortedSquares(int[] ary) {
        // 双指针， 是一种很有用的方法
        // 从左右两边分别往中间移动
        int left = 0;
        int right = ary.length - 1;

        // 用于标记下一个元素需要插入的位置
        int idx = right;
        int[] result = new int[ary.length];

        while (left <= right) {
            int leftSquare = ary[left] * ary[left];
            int rightSquare = ary[right] * ary[right];
            if (leftSquare >= rightSquare) {
                left++;
                result[idx--] = leftSquare;
            } else {
                right--;
                result[idx--] = rightSquare;
            }
        }
        return result;
    }
}
