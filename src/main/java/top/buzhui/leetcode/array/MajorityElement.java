package top.buzhui.leetcode.array;

/**
 * <a href="https://leetcode-cn.com/problems/find-majority-element-lcci/">主要元素</a>
 * <br>
 * 扩展： 当求超过 1/3 时，该如何处理
 *
 * @author iyuhp created at 2020/10/16
 */
public class MajorityElement {

    public static void main(String[] args) {
        // expected 1
        System.out.println(majorityElement(new int[]{1, 2, 1, 1, 3, 1, 1, 2}));
        // expected -1
        System.out.println(majorityElement(new int[]{1, 2, 1, 3, 1, 2}));
    }

    private static int majorityElement(int[] nums) {
        int majority = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
            }
            count += (majority == num) ? 1 : -1;
        }

        // 判断最后一个元素是否一定超过了半数
        count = 0;
        int half = nums.length / 2;
        for (int num : nums) {
            if (num == majority) {
                count += 1;
            }
            if (count > half) {
                return majority;
            }
        }
        return -1;
    }
}
