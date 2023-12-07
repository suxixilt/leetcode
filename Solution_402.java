/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 * 示例 1 ：
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * <p>
 * 示例 2 ：
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例 3 ：
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 */
public class Solution_402 {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
//        输出："200"
        String res = removeKdigits(num, k);
        System.out.println(res);
    }

    public static String removeKdigits(String num, int k) {
        StringBuffer n = new StringBuffer(num);
        if (k == n.length()) {
            return "0";
        }
        while (k > 0) {
            int idx = 0;
            for (int i = 1; i < n.length() && n.charAt(i) > n.charAt(i - 1); i++) {
                idx = i;
            }
            n.delete(idx, idx + 1);
            while (n.length() > 1 && n.charAt(0) == '0') {
                n.delete(0, 1);
            }
            k--;
        }
        String res = new String(n);
        return res.equals("") ? "0" : res;
    }
}
