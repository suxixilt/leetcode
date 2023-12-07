/**
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s .
 * 它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，
 * 其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。
 * 对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 * <p>
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * <p>
 * 示例 1:
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * <p>
 * 示例 2:
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 105
 * s 只包含字符 '*' 和 '|' 。
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= lefti <= righti < s.length
 */
public class Solution_2055 {
    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        // 输出：[9,0,0,0,0]
//        String s = "**|**|***|";
//        int[][] queries = new int[][]{{2, 5}, {5, 9}};

        int[] ints = platesBetweenCandles(s, queries);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int[] count = new int[queries.length];
        int[] left_candle = new int[chars.length];
        int[] right_candle = new int[chars.length];
        int[] preSum = new int[chars.length];
        // 盘子的前缀和
        for (int i = 0, sum = 0; i < preSum.length; i++) {
            if (chars[i] == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        // candles of left index
        for (int i = 0, p = -1; i < left_candle.length; i++) {
            if (chars[i] == '|')
                p = i;
            left_candle[i] = p;
        }
        // candles of right index
        for (int i = right_candle.length - 1, p = -1; i > 0; i--) {
            if (chars[i] == '|')
                p = i;
            right_candle[i] = p;
        }


        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            count[i] = right_candle[start] == -1 || left_candle[end] == -1 || left_candle[end] <= right_candle[start] ? 0 : preSum[left_candle[end]] - preSum[right_candle[start]];

        }
        return count;
    }
}
