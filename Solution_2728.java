/**
 * 给你一个三位数整数 n 。
 * 如果经过以下修改得到的数字 恰好 包含数字 1 到 9 各一次且不包含任何 0 ，那么我们称数字 n 是 迷人的 ：
 * 将 n 与数字 2 * n 和 3 * n 连接 。
 * 如果 n 是迷人的，返回 true，否则返回 false 。
 * 连接 两个数字表示把它们首尾相接连在一起。比方说 121 和 371 连接得到 121371 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 192
 * 输出：true
 * 解释：我们将数字 n = 192 ，2 * n = 384 和 3 * n = 576 连接，得到 192384576 。这个数字包含 1 到 9 恰好各一次。
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：false
 * 解释：我们将数字 n = 100 ，2 * n = 200 和 3 * n = 300 连接，得到 100200300 。这个数字不符合上述条件。
 */
public class Solution_2728 {

    public static void main(String[] args) {
        int n = 783;
        boolean flag = isFascinating(n);
        System.out.println(flag);
    }

    public static boolean isFascinating(int n) {
        return check_in(new int[][]{get_number(n), get_number(n * 2), get_number(n * 3)}, new int[10]);
    }

    public static int[] get_number(int n) {
        int first = n / 1000;
        int second = n % 1000 / 100;
        int third = n % 100 / 10;
        int forth = n % 10;
        return new int[]{first, second, third, forth};
    }

    public static boolean check_in(int[][] number, int[] count) {
        for (int[] num : number) {
            for (int i : num) {
                count[i] += 1;
            }
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0 || count[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
