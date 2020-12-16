/**
 * @author：licailin
 * 缺失的最小正整数
 * 题目地址：https://leetcode-cn.com/problems/missing-number/
 * 解题思路：
    1、时间复杂度O（n*㏒n + O（n））
    2、先快速排序，获取到有序数列
    3、顺序访问每个元素
 */
public class MissMinNum {

    public static int[] fastSort(int[] num, int start, int end) {
        // 一定要做start < end 的判断
        if(start < end) {
            int i = start;
            int j = end;
            int flag = num[start];
            while (i < j) {
                // 从右边开始找，找到第一个比基准数小的，然后进行交换
                while (i < j && num[j] > flag) {
                    j --;
                }
                if (i < j) {
                    num[i] = num[j];
                    i ++;
                }
                while (i < j && num[i] < flag) {
                    i ++;
                }
                if (i < j) {
                    num[j] = num[i];
                    j --;
                }
            }
            num[i] = flag;
            fastSort(num, start, i - 1);
            fastSort(num, i + 1, end);
        }
        return num;
    }

    public static int missMinNum(int[] bbb) {
        int[] num = fastSort(bbb, 0, bbb.length - 1);
        int idx = 0;
        while (idx < num.length - 1) {
            // 忽略负数
            if (num[idx] <= 0) {
                idx ++;
                continue;
            }

            // 第一个大于0的正整数
            if (num[idx] > 1 && (idx >= 1 && num[idx - 1] <= 0)) {
                return 1;
            }

            // 如果刚好等于1，判断下一位
            if (idx + 1 < num.length - 1 && num[idx + 1] - num[idx] > 1) {
                return num[idx] + 1;
            }
            idx ++;
        }
        return num[num.length - 1] + 1;
    }

    public static void main(String[] args) {
        int[] a = {-1, -2, 0};
        System.out.println(missMinNum(a));
    }
}
