/**
 * @author lcl
 * 判断一个字符串前后是否相似
 * 题目：https://leetcode-cn.com/problems/determine-if-string-halves-are-alike/
 * 解题思路： 保证字符串长度一定是偶数长度，类似于双指针，一个在前，一个在后，同时移动，统计前后的元音字母
 * 当两个指针相遇时，判断前后统计是否相等，如果相等，返回true，反之，返回false
 * 特别注意，如何判断字符串是否包含一个字符，String.indexOf(char), 字符串取一个字符，String.charAt()
 */
public class IsStringSimilar {

    public static boolean isStringSimilar(String s) {
        if (null == s || "".equals(s) || s.length() < 2) {
            return false;
        }

        String flag = "AEIOUaeiou";
        int front = 0;
        int after = 0;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (-1 != flag.indexOf(s.charAt(i))){
                front ++;
            }

            if (-1 != flag.indexOf(s.charAt(j))) {
                after ++;
            }
            i ++;
            j --;
        }
        return front == after;
    }

    public static void main(String[] args) {
        System.out.println(isStringSimilar("AbCdEfGh"));
    }
}
