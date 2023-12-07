import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
 * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
 * 0，如果上述条件全部不满足
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 2
 * <p>
 * 示例 2：
 * 输入：nums = [2,4,6,4]
 * 输出：1
 * 解释：对于每个符合范围 1 <= i <= 2 的下标 i :
 * - nums[1] 的美丽值等于 1
 * - nums[2] 的美丽值等于 0
 * <p>
 * 示例 3：
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 0
 * <p>
 * 提示：
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Solution_2012 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 6};
        int res = sumOfBeauties(nums);
        System.out.println(res);
    }

    /**
     * 维护两个数组 一个包含左边的最大值 一个包含右边的最小值
     */
    public static int sumOfBeauties(int[] nums) {
        int count = 0;
        int[] lmax = new int[nums.length];
        int[] rmin = new int[nums.length];
        Arrays.fill(rmin, Integer.MAX_VALUE);
        for (int i = 1; i < lmax.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], nums[i - 1]);
        }
        for (int i = rmin.length - 2; i > 0; i--) {
            rmin[i] = Math.min(rmin[i + 1], nums[i + 1]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > lmax[i] && nums[i] < rmin[i])
                count += 2;
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1])
                count++;
        }
        return count;
    }
}
