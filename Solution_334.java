/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * <p>
 * 示例 2：
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class Solution_334 {

    public static void main(String[] args) {
        int[] nums = new int[]{20, 100, 10, 12, 5, 13};
//        [20,20,10,10,5,5]
//        [100,100,13,13,13,13]
        boolean res = increasingTriplet(nums);
        System.out.println(res);
    }

    /**
     * 还可以使用贪心算法 维护两个变量 first second 代表三元递增组的前两个数
     * 初始first = nums[0],   second = Integer.MAX_VALUE
     * 开始遍历nums 对于 1 <= i <= nums.Length - 1
     * 1.                  if nums[i] > second     return true
     * 2. not 1            if nums[i] > first      second = nums[i]
     * 3. not (1 and 2)                            first = nums[i]
     * 核心思想就是 让 first 和 second 尽可能的小 然后遍历nums[i]
     */
    public static boolean increasingTriplet(int[] nums) {
        int[] lmin = new int[nums.length];
        int[] rmax = new int[nums.length];
        for (int i = 0, sum = Integer.MAX_VALUE; i < lmin.length; i++) {
            if (nums[i] < sum) {
                sum = nums[i];
            }
            lmin[i] = sum;
        }
        for (int i = rmax.length - 1, sum = Integer.MIN_VALUE; i >= 0; i--) {
            if (nums[i] > sum) {
                sum = nums[i];
            }
            rmax[i] = sum;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > lmin[i] && nums[i] < rmax[i])
                return true;
        }
        return false;
    }

}



