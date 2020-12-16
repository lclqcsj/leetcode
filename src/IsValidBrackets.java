import java.util.Stack;

/**
 * @author：licailin
 * 题目：有效的括号
 * 题目地址：https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValidBrackets {

    public static boolean isValid(String str) {
        if (0 == str.length()) {
            return true;
        }

        // 不是2的倍数，返回false
        if (0 != str.length() % 2) {
            return false;
        }
        String leftStr = "{([";
        Stack<Character> stack = new Stack<>();

        int idx = 0;
        while (idx < str.length()) {
            // 满足左边匹配的，直接压栈
            if (-1 != leftStr.indexOf(str.charAt(idx))) {
                stack.push(str.charAt(idx));
            } else {
                // 遇到右边括号，队列为空，不满足，直接return false
                if (stack.empty() && idx < str.length()) {
                    return false;
                }

                // 分情况讨论
                if (str.charAt(idx) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (str.charAt(idx) == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (str.charAt(idx) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            idx ++;
        }
        return stack.empty();
    }

    public static void main(String[] args){
        System.out.println(IsValidBrackets.isValid("(){}}{"));
    }
}
