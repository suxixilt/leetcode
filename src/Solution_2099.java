import java.util.Arrays;

/**
 * 求一个数组中前k个最大的值 按数组原本的顺序返回
 */
public class Solution_2099 {
    public static void main(String[] args) {
        int[] nums = new int[]{50, -75};
        int k = 2;
        System.out.println(Arrays.toString(new Solution_2099().maxSubsequence(nums, k)));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] idx = new int[n][2];
        int[] res = new int[k];
        for (int i = 0; i < n; i++) {
            idx[i][0] = nums[i];
            idx[i][1] = i;
        }
        Arrays.sort(idx, (a, b) -> b[0] - a[0]);
        Arrays.sort(idx, 0, k, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < k; i++) {
            res[i] = idx[i][0];
        }
        return res;
    }
}

