public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next;
            second = second.next;
        }
        return first;

    }
}
