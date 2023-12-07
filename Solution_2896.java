/**
 * 给你两个下标从 0 开始的二进制字符串 s1 和 s2 ，两个字符串的长度都是 n ，再给你一个正整数 x 。
 * 你可以对字符串 s1 执行以下操作 任意次 ：
 * 选择两个下标 i 和 j ，将 s1[i] 和 s1[j] 都反转，操作的代价为 x 。
 * 选择满足 i < n - 1 的下标 i ，反转 s1[i] 和 s1[i + 1] ，操作的代价为 1 。
 * 请你返回使字符串 s1 和 s2 相等的 最小 操作代价之和，如果无法让二者相等，返回 -1 。
 * 注意 ，反转字符的意思是将 0 变成 1 ，或者 1 变成 0 。
 * <p>
 * 示例 1：
 * 输入：s1 = "1100011000", s2 = "0101001010", x = 2
 * 输出：4
 * 解释：我们可以执行以下操作：
 * - 选择 i = 3 执行第二个操作。结果字符串是 s1 = "1101111000" 。
 * - 选择 i = 4 执行第二个操作。结果字符串是 s1 = "1101001000" 。
 * - 选择 i = 0 和 j = 8 ，执行第一个操作。结果字符串是 s1 = "0101001010" = s2 。
 * 总代价是 1 + 1 + 2 = 4 。这是最小代价和。
 * <p>
 * 示例 2：
 * 输入：s1 = "10110", s2 = "00011", x = 4
 * 输出：-1
 * 解释：无法使两个字符串相等。
 * <p>
 * 提示：
 * <p>
 * n == s1.length == s2.length
 * 1 <= n, x <= 500
 * s1 和 s2 只包含字符 '0' 和 '1' 。
 */
public class Solution_2896 {
    public static void main(String[] args) {
        String s1 = "1100011000";
        String s2 = "0101001010";
        int x = 2;
        minOperations(s1,s2,x);
    }
    public static int minOperations(String s1, String s2, int x) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[] count = new int[ch1.length];
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                count[i] = 1;
            }
        }
        int total = 0;
        for (int i : count) {
            System.out.print(i);
            System.out.print('\t');
            total += i;
        }
        if (total % 2 != 0) {
            return -1;
        } else {

        }
        return 0;
    }

}
