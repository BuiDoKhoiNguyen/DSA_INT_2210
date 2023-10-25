import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static class QueueUsingTwoStacks {
        private Stack<Integer> stackNewestOnTop = new Stack<>();
        private Stack<Integer> stackOldestOnTop = new Stack<>();

        public void enqueue(Integer x) {
            stackNewestOnTop.push(x);
        }

        private void reverseStack() {
            if (stackOldestOnTop.isEmpty())
                while (!stackNewestOnTop.isEmpty()) stackOldestOnTop.push(stackNewestOnTop.pop());
        }

        public Integer dequeue() {
            reverseStack();
            return stackOldestOnTop.pop();
        }

        public Integer print() {
            reverseStack();
            return stackOldestOnTop.peek();
        }
    }


}
