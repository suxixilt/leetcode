/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * 示例 1：
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * <p>
 * 示例 2：
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * 提示：
 * 树中的节点数在 [1, 104]范围内
 * -105 <= Node.val <= 105
 */

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1161 {

    public static void main(String[] args) {
//        [-100,-200,-300,-20,-5,-10,null]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right.left = new TreeNode(-7);
        root.right.right = new TreeNode(9);
        System.out.println(new Solution_1161().maxLevelSum(root));
    }

    public int maxLevelSum(TreeNode root) {
        int total = root.val;
        int floor = 1;
        int temp; // 当前层总和
        int cur = 1; // 当前层数
        TreeNode m;
        Queue<TreeNode> q1 = new ArrayDeque<TreeNode>();
        q1.add(root);
        while (!q1.isEmpty()) {
            temp = 0;
            int n = q1.size();
            for (int i = 0; i < n; i++) {
                m = q1.poll();
                temp += m.val;
                if (m.left != null) {
                    q1.add(m.left);
                }
                if (m.right != null) {
                    q1.add(m.right);
                }
            }
            if (temp > total) {
                total = temp;
                floor = cur;
            }
            if (temp == total) {
                floor = Math.min(floor, cur);
            }
            cur++;
        }
        return floor;
    }
}