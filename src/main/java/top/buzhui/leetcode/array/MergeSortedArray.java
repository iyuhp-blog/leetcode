package top.buzhui.leetcode.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/merge-sorted-array/">合并两个有序数组</a>
 *
 * @author iyuhp created at 2020/10/17
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{2, 0}, 1, new int[]{1}, 1)));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(Arrays.toString(merge2(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
        System.out.println(Arrays.toString(merge2(new int[]{2, 0}, 1, new int[]{1}, 1)));
    }

    /**
     * 前提： nums1 有足够的空ing将来保存 nums2 中的元素
     * ==> nums1.length >= m + n
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int idx = m + n - 1;
        do {
            if (left >= 0 && right >= 0) {
                int num1 = nums1[left];
                int num2 = nums2[right];
                if (num1 >= num2) {
                    nums1[idx--] = num1;
                    left--;
                } else {
                    nums1[idx--] = num2;
                    right--;
                }
            } else if (right >= 0) {
                    nums1[idx--] = nums2[right];
                    right--;
            }

        } while (right >= 0);
        return nums1;
    }

    private static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int idx = m-- + n-- - 1;

        while (m >= 0 && n >= 0) {
            nums1[idx--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        // 处理 num1 左指针已经走完但 num2 右指针还未走完的情况
        while (n >= 0) {
            nums1[idx--] = nums2[n--];
        }
        return nums1;
    }
}
