import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 */
public class Solution_930 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0, 0};
        int goal = 0;
        System.out.println(new Solution_930().numSubarraysWithSum(nums, goal));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            temp += num;
            if (map.containsKey(temp - goal)) {
                count += map.get(temp - goal);
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return count;
    }
}
