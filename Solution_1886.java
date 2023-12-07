/**
 * 给你两个大小为 （n x n） 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，
 * 如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * <p>
 * 示例 2：
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * <p>
 * 示例 3：
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 */
public class Solution_1886 {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        boolean flag = findRotation(mat, target);
        System.out.println(flag);
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        return checkEqual(mat, target) || checkEqual(mat, rotate(target)) ||
                checkEqual(mat, rotate(rotate(target))) ||
                checkEqual(mat, rotate(rotate(rotate(target))));
    }

    public static int[][] rotate(int[][] mat) {
        int[][] newMat = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                newMat[j][mat[0].length - 1 - i] = mat[i][j];
            }
        }
        return newMat;
    }

    public static boolean checkEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
}

/*
时间 0ms 击败 100.00%使用 Java 的用户
内存 38.68MB 击败 21.74%使用 Java 的用户
 */
