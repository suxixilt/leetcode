import java.util.*;

/**
 * 给你一个长度为 n 下标从 0 开始的数组 nums ，数组中的元素为 互不相同 的正整数。
 * 请你返回让 nums 成为递增数组的 最少右移 次数，如果无法得到递增数组，返回 -1 。
 * 一次 右移 指的是同时对所有下标进行操作，将下标为 i 的元素移动到下标 (i + 1) % n 处。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：2
 * 解释：
 * 第一次右移后，nums = [2,3,4,5,1] 。
 * 第二次右移后，nums = [1,2,3,4,5] 。
 * 现在 nums 是递增数组了，所以答案为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,5]
 * 输出：0
 * 解释：nums 已经是递增数组了，所以答案为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,4]
 * 输出：-1
 * 解释：无法将数组变为递增数组。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * nums 中的整数互不相同。
 */


public class Solution_2855 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(72);
        nums.add(13);
        nums.add(21);
        nums.add(35);
        nums.add(52);
        int count = minimumRightShifts(nums);
        System.out.println(count);
    }

    public static int minimumRightShifts(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                for (int j = 0; j < nums.size() - i - 1; j++) {
                    if (nums.get((i + j + 1) % nums.size()) > nums.get((i + j + 2) % nums.size())) {
                        return -1;
                    }
                }
                return nums.size() - i - 1;
            }
        }
        return 0;
    }
}
