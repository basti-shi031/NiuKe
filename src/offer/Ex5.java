package offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Ex5 {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack1.empty()) {
                return -1;
            }

            while (!stack1.empty()) {
                Integer i = stack1.pop();
                stack2.push(i);
            }
            Integer pop = stack2.pop();

            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }

            return pop;
        }
    }
}
