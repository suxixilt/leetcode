/**
 * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
 * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,2]
 * 输出：true
 * 解释：有 1 个全局倒置，和 1 个局部倒置。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：false
 * 解释：有 2 个全局倒置，和 1 个局部倒置。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i] < n
 * nums 中的所有整数 互不相同
 * nums 是范围 [0, n - 1] 内所有数字组成的一个排列
 */
public class Solution_775 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0};
        boolean flag = isIdealPermutation(nums);
        System.out.println(flag);
    }

    // 双层for循环 超时
    // nums 中的所有整数 互不相同
    // nums 是范围 [0, n - 1] 内所有数字组成的一个排列
    // 全局倒置一定是局部倒置 但局部倒置不一定是全局倒置 也就是说 如果有两个数全局倒置 但是相距大于1 那么就只是全局倒置但不是局部倒置
    // 而且n个数个不相同 结合这个条件 那么每个数和自己下标到距离不能超过2
    public static boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
