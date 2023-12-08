/**
 * 小扣在探索丛林的过程中，无意间发现了传说中“落寞的黄金之都”。而在这片建筑废墟的地带中，小扣使用探测仪监测到了存在某种带有「祝福」效果的力场。
 * 经过不断的勘测记录，小扣将所有力场的分布都记录了下来。forceField[i] = [x,y,side] 表示第 i 片力场将覆盖以坐标 (x,y) 为中心，边长为 side 的正方形区域。
 * 若任意一点的 力场强度 等于覆盖该点的力场数量，请求出在这片地带中 力场强度 最强处的 力场强度。
 * 注意：
 * 力场范围的边缘同样被力场覆盖。
 * <p>
 * 示例 1：
 * 输入： forceField = [[0,0,1],[1,0,1]]
 * 输出：2
 * 解释：如图所示，（0.5, 0) 处力场强度最强为 2， （0.5，-0.5）处力场强度同样是 2。image.png
 * <p>
 * 示例 2：
 * 输入： forceField = [[4,4,6],[7,5,3],[1,6,2],[5,6,3]]
 * 输出：3
 * 解释：如下图所示， forceField[0]、forceField[1]、forceField[3] 重叠的区域力场强度最大，返回 3image.png
 * <p>
 * 提示：
 * 1 <= forceField.length <= 100
 * forceField[i].length == 3
 * 0 <= forceField[i][0], forceField[i][1] <= 10^9
 * 1 <= forceField[i][2] <= 10^9
 */
public class Solution_29 {
    /**
     * 1 2 3 4
     * 3 4 5 5
     * 2 7 6 6
     * 1 9 8 7
     */
    public static void main(String[] args) {
        System.out.println(new Solution_29().orchestraLayout(877225311, 445777399, 843543753));
    }

    public int orchestraLayout(int num, int xPos, int yPos) {
        long in_circle = Math.min(Math.min(xPos, yPos), Math.min(num - xPos - 1, num - yPos - 1)) + 1;
        long in_circle_l = num - 2 * (in_circle - 1);
        // double 11位阶码 52位数值位 存在隐藏的1位 当数值位大于53 阶码大于52时 就可能出现精度问题
        // long 64位 long表示的精度要比double大
        long area = (long) num * num - in_circle_l * in_circle_l;
        long index = area % 9 + 1;
        long x = in_circle - 1;
        long y = in_circle - 1;
        if (y == yPos && x == xPos)
            return (int) index;
        if (y == yPos) {
            return (int) ((index + in_circle_l * 4 - 4 - (xPos - x) - 1) % 9) + 1;
        }
        if (x == xPos) {
            return (int) ((index + yPos - y - 1) % 9) + 1;
        }
        if (xPos == x + in_circle_l - 1) {
            return (int) ((index + in_circle_l * 3 - 3 - (yPos - y) - 1) % 9) + 1;
        }
        if (yPos == y + in_circle_l - 1) {
            return (int) ((index + in_circle_l - 1 + (xPos - x) - 1) % 9) + 1;
        }
        return 0;
    }
}