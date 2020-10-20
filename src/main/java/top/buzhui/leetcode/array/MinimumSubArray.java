package top.buzhui.leetcode.array;

/**
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * @author hexiao
 * Created At 2020/10/19
 */
public class MinimumSubArray {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(9, new int[]{2, 3, 1, 9, 2, 4, 3}));
        System.out.println(minSubArrayLen(3, new int[]{1, 1}));
    }

    private static int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int sum = 0;
        int answer = nums.length + 1;
        int left = 0;
        int right = 0;

        while (right < length) {
            sum += nums[right];

            while (sum >= s) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        System.out.println("left:" + left);
        return answer <= length ? answer : 0;
    }
}
