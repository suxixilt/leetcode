/**
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * 示例 2：
 * <p>
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s[i] 和 c 均为小写英文字母
 * 题目数据保证 c 在 s 中至少出现一次
 */
public class Solution_821 {
    public static void main(String[] args) {
        String s = "baaa";
        char c = 'b';
//        String s = "loveleetcode"; char c = 'e';
//        [3,2,1,0,1,0,0,1,2,2,1,0]
        int[] distant = shortestToChar(s, c);
        System.out.println("distant:");
        for (int i : distant) {
            System.out.print(i);
            System.out.print('\t');
        }
    }

    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] distant = new int[n];
        char[] ch = s.toCharArray();
        for (int i = 0, l = -1; i < n; i++) {
            if (ch[i] == c) {
                l = i;
                distant[i] = 0;
            }
            left[i] = l;
        }
        System.out.println("left:");
        for (int i : left) {
            System.out.print(i);
            System.out.print('\t');
        }
        System.out.println();
        for (int i = n - 1, l = -1; i > -1; i--) {
            if (ch[i] == c) {
                l = i;
            }
            right[i] = l;
        }
        System.out.println("right:");
        for (int i : right) {
            System.out.print(i);
            System.out.print('\t');
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (ch[i] != c) {
                int l = left[i] != -1 ? Math.abs(i - left[i]) : -1;
                int r = right[i] != -1 ? Math.abs(i - right[i]) : -1;
                if (l > 0 && r > 0) {
                    distant[i] = Math.min(l, r);
                } else if (l > 0 && r == -1) {
                    distant[i] = l;
                } else if (l == -1 && r > 0) {
                    distant[i] = r;
                }
            }
        }
        return distant;
    }
}
