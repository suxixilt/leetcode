import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Solution_869 {
    public static void main(String[] args) {
        boolean flag = reorderedPowerOf2(812);
        System.out.println(flag);
    }

    public static boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        // int 4B 其中最高位表示符号 左移溢出后变为负数
        for (int i = 1; i > 0; i = i * 2) {
            set.add(getNum(i));
        }
        return set.contains(getNum(n));
    }

    public static String getNum(int i) {
        char[] c = String.valueOf(i).toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
