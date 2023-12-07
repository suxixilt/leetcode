import java.util.ArrayList;
import java.util.Collections;

/**
 * 给你两个长度相等的整数数组，返回下面表达式的最大值：
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 * 其中下标 i，j 满足 0 <= i, j < arr1.length。
 * <p>
 * 示例 1：
 * 输入：arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * 输出：13
 * <p>
 * 示例 2：
 * 输入：arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * 输出：20
 * <p>
 * 提示：
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 */
public class Solution_1131 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, -2, -5, 0, 10};
        int[] arr2 = new int[]{0, -2, -1, -7, -4};
        // * 输出：20
        int i = maxAbsValExpr(arr1, arr2);
        System.out.println(i);
    }

    /**
     * 对于 |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
     * 去掉绝对值 将 i和j 分开
     * arr1[i] + arr2[i] + i - (arr1[j] + arr2[j] + j)
     * arr1[i] - arr2[i] + i - (arr1[j] - arr2[j] + j)
     * arr1[i] - arr2[i] - i - (arr1[j] - arr2[j] - j)
     * -arr1[i] + arr2[i] + i - (-arr1[j] + arr2[j] + j)
     * -arr1[i] + arr2[i] - i - (-arr1[j] + arr2[j] - j)
     * ... 共有八种 其中 形式类似
     * 令 A = arr1[i] + arr2[i] + i
     * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
     * =  max( (max(A) - min(A)),
     * (max(B) - min(B)),
     * (max(C) - min(C)),
     * (max(D) - min(D)))
     */
    public static int maxAbsValExpr(int[] arr1, int[] arr2) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            A.add(arr1[i] + arr2[i] + i);
            B.add(arr1[i] - arr2[i] + i);
            C.add(arr1[i] - arr2[i] - i);
            D.add(arr1[i] + arr2[i] - i);
        }
        int a1 = Math.max(
                (Collections.max(A) - Collections.min(A)),
                (Collections.max(B) - Collections.min(B)));
        int a2 = Math.max(
                (Collections.max(C) - Collections.min(C)),
                (Collections.max(D) - Collections.min(D)));
        return Math.max(a1, a2);

    }
}
