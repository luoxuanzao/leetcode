import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1019 {

    Deque<ListNode> stack = new LinkedList<>();
    int[] ans;

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        f(head, 0);
        return ans;
    }

    public void f(ListNode head, int n) {
        if (head == null) {
            ans = new int[n];
            return;
        }
        f(head.next, n + 1);
        while (!stack.isEmpty() && stack.peek().val <= head.val) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            ans[n] = stack.peek().val;
        }
        stack.add(head);
    }


}
