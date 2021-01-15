import java.util.BitSet;

/**
 * @author lcl
 * 数组中重复数字， 题目链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/submissions/
 * 类似题目，数组中是否存在相同数字，找出相同数字，相同数字出现次数等
 * 如果题目限定只有正整数，可以考虑使用bit数据结构来存储，1Byte=8bit，时间复杂度O（n）
 * 如果数据出现负数，则两种解决办法，其一：排序， 再遍历 O（n） + O（NlogN），其二，利用集合操作，空间换时间，时间复杂度O（n） 空间复杂度O（n）
 * 最好等解法，异位运算，时间复杂度O（n）
 */
public class FindRepeatNum {


    static int findRepeatNumber(int[] nums) {
        BitSet bitSet = new BitSet(100001);

        int result = 0;
        for (int n: nums) {
            if (bitSet.get(n)) {
                result = n;
                break;
            }
            bitSet.set(n);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] num = {1,2,3,4,2,3,4};
        System.out.println(findRepeatNumber(num));
    }

}
