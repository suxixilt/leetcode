/**
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * <p>
 * 示例 1:
 * 输入: n = 10
 * 输出: 9
 * <p>
 * 示例 2:
 * 输入: n = 1234
 * 输出: 1234
 * <p>
 * 示例 3:
 * 输入: n = 332
 * 输出: 299
 * <p>
 * 提示:
 * <p>
 * 0 <= n <= 109
 */
public class Solution_738 {
    public static void main(String[] args) {
        System.out.println(new Solution_738().monotoneIncreasingDigits(332));
    }

    public int monotoneIncreasingDigits(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        int csn = cs.length - 1;
        for (int i = csn; i > 0; i--) {
            if (cs[i] < cs[i - 1]) {
                cs[i] = '9';
                cs[i - 1]--;
                for (int j = i + 1; j <= csn; j++) {
                    cs[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(cs));
    }
}
