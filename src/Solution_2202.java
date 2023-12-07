/**
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个 栈 ，其中 nums[0] 是栈顶的元素。
 * 每一次操作中，你可以执行以下操作 之一 ：
 * 如果栈非空，那么 删除 栈顶端的元素。
 * 如果存在 1 个或者多个被删除的元素，你可以从它们中选择任何一个，添加 回栈顶，这个元素成为新的栈顶元素。
 * 同时给你一个整数 k ，它表示你总共需要执行操作的次数。
 * 请你返回 恰好 执行 k 次操作以后，栈顶元素的 最大值 。如果执行完 k 次操作以后，栈一定为空，请你返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [5,2,2,4,0,6], k = 4
 * 输出：5
 * 解释：
 * 4 次操作后，栈顶元素为 5 的方法之一为：
 * - 第 1 次操作：删除栈顶元素 5 ，栈变为 [2,2,4,0,6] 。
 * - 第 2 次操作：删除栈顶元素 2 ，栈变为 [2,4,0,6] 。
 * - 第 3 次操作：删除栈顶元素 2 ，栈变为 [4,0,6] 。
 * - 第 4 次操作：将 5 添加回栈顶，栈变为 [5,4,0,6] 。
 * 注意，这不是最后栈顶元素为 5 的唯一方式。但可以证明，4 次操作以后 5 是能得到的最大栈顶元素。
 * <p>
 * 示例 2：
 * 输入：nums = [2], k = 1
 * 输出：-1
 * 解释：
 * 第 1 次操作中，我们唯一的选择是将栈顶元素弹出栈。
 * 由于 1 次操作后无法得到一个非空的栈，所以我们返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i], k <= 109
 */

class Solution_2202 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 2, 4, 0, 6};
        int k = 4;
        System.out.println(new Solution_2202().maximumTop(nums, k));
    }

    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return nums[0];
        }
        if (n == 1 && k % 2 == 1) {
            return -1;
        }
        if (n == 1 && k % 2 != 1) {
            return nums[0];
        }
        int temp = -1;
        if (n == k) {
            for (int i = 0; i < n - 1; i++) {
                temp = Math.max(temp, nums[i]);
            }
            return temp;
        }
        if (n > k) {
            for (int i = 0; i < k - 1; i++) {
                temp = Math.max(temp, nums[i]);
            }
            return Math.max(temp, nums[k]);
        }
        for (int num : nums) {
            temp = Math.max(temp, num);
        }
        return temp;
    }
}