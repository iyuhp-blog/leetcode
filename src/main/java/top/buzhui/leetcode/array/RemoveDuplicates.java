package top.buzhui.leetcode.array;

/**
 * @author iyuhp created at 2020/10/18
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 3, 3, 3}));
        System.out.println(removeDuplicatesNoMoreThan2(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(ah(new int[]{1, 1, 1, 2, 2, 3}));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[idx]) {
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }

    private static int removeDuplicatesNoMoreThan2(int[] nums) {
        int idx = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] == nums[i]) {
                if (++count < 3) {
                    nums[++idx] = nums[i];
                }
            } else {
                nums[++idx] = nums[i];
                count = 1;
            }
        }
        return idx + 1;
    }

    private static int ah(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
