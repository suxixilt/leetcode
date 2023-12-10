/**
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * <p>
 * 示例 1：
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 */
public class Solution_771 {

    public static void main(String[] args) {
        String jewels = "z";
        String stones = "ZZ";
        System.out.println(new Solution_771().numJewelsInStones(jewels, stones));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char s : stones.toCharArray()) {
            if (jewels.contains(String.valueOf(s))) {
                count++;
            }
        }
        return count;
    }
}
