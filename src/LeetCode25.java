public class LeetCode25 {


    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode point = head;
        for (int i = 0; i < k; i++) {
            if (point == null) {
                return head;
            }
            point = point.next;
        }

        ListNode last = reverseN(head, k);
        head.next = reverseKGroup(point, k);
        return last;
    }
}
