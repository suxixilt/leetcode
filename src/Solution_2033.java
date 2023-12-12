import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
 * 单值网格 是全部元素都相等的网格。
 * 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[2,4],[6,8]], x = 2
 * 输出：4
 * 解释：可以执行下述操作使所有元素都等于 4 ：
 * - 2 加 x 一次。
 * - 6 减 x 一次。
 * - 8 减 x 两次。
 * 共计 4 次操作。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,5],[2,3]], x = 1
 * 输出：5
 * 解释：可以使所有元素都等于 3 。
 * <p>
 * 示例 3：
 * 输入：grid = [[1,2],[3,4]], x = 2
 * 输出：-1
 * 解释：无法使所有元素相等。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= x, grid[i][j] <= 104
 */

public class Solution_2033 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{980, 476, 644, 56, 980}, {644, 140, 812, 308, 980}, {812, 812, 896, 560, 980}, {728, 476, 56, 812, 980}};
        int x = 84;
        System.out.println(new Solution_2033().minOperations(grid, x));
    }

    public int minOperations(int[][] grid, int x) {
        if (grid.length * grid[0].length == 1) {
            return 0;
        }
        int[] nums = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                nums[i * grid[0].length + j] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int count = 0;
        for (int num : nums) {
            if ((mid - num) % x != 0) {
                return -1;
            } else {
                count += Math.abs((mid - num) / x);
            }
        }
        return count;
    }
}
