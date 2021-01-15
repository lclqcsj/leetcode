import java.util.Stack;

/**
 * @author lcl
 * 栈的压入弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * 解题思路
 * 用一个栈来辅助，当元素不同时候，直接入栈，如果相同，下标同时挪动下一位，且先判断栈内元素是否与入栈序列相同，相同出栈
 * 最后判断栈是否为空即可
 */
public class ValidateStackSequences {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // 为空，或者一样的时候，直接返回true
        if (pushed == popped) {
            return true;
        }

        // 当长度不等时，一定不是
        if (pushed.length != popped.length) {
            return false;
        }

        // 开始遍历
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int i : pushed) {
            // 值不一样，分队列是否为空讨论
            if (i != popped[popIdx]) {
                stack.add(i);
                continue;
            }
            popIdx ++;
            while (!stack.isEmpty() && popIdx < popped.length) {
                if (stack.peek() == popped[popIdx]) {
                    stack.pop();
                    popIdx ++;
                    continue;
                }
                break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] poped = {5,3,4,2,1};
        System.out.println(validateStackSequences(pushed, poped));
    }

}
