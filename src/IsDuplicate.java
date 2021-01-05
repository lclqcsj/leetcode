
import java.util.HashSet;


/**
 * @author lcl
 * 判断一个数组中，是否出现重复元素
 * 题目链接：https://leetcode-cn.com/problems/contains-duplicate/
 * 解法1：暴力，时间复杂度O（n**2），两个for循环暴力解决，此时，最坏的情况是，重复的数据刚好是一头一尾, 有timeout风险
 * 解法2：先排序，然后一个一个比较，平均复杂度O（N） + O（logN）
 * 解法3：空间换时间方法，知道数组中出现的最大值是多少，定义一个最大值数组，遍历nums，出现的地方就使用1标记，反之，为0
 *       当再次有数据过来时，该数据就为出现了2次（仅限正整数情况）
 * 解法4：bit，java 下使用byte数组来实现，思路如解法三（仅限正整数情况）
 * 解法5：用集合操作，还是空间换时间思路
 *
 */
public class IsDuplicate {

    static boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet(nums.length);
        for (int n: nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2,3, -2};
        System.out.println(containsDuplicate(nums));
    }
}
