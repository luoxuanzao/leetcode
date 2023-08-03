import java.util.Deque;
import java.util.LinkedList;

public class LeetCode946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < pushed.length) {
            stack.push(pushed[pushIndex]);
            while (popIndex < popped.length && stack.peek() != null && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
            pushIndex++;
        }
        return stack.isEmpty();
    }
}
