public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode point = head;
        while (point.next != null) {
            len += 1;
            point = point.next;
        }
        point.next = head;
        k = k % len;
        point = head;
        for (int i = 0; i < len - k; i++) {
            point = point.next;
        }
        head = point;
        for (int i = 0; i < len - 1; i++) {
            point = point.next;
        }
        point.next = null;
        return head;
    }
}
