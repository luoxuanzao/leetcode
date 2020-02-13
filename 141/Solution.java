import java.util.HashMap;
import java.util.HashSet;

class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }


    }
    HashSet set = new HashSet();

//    public boolean hasCycle(ListNode head) {
//        if (head == null) return false;
//        while (head != null) {
//            if (!set.contains(head)) {
//                set.add(head);
//                head = head.next;
//            } else return false;
//        }
//        return true;
//    }

    /**
     * 用双指针 快的一次走两个 慢的一次走一个
     * 如果快的能走到null 说明不是环形
     * 如果快的跟慢的重合了 说明是环形
     * @param head
     * @return
     */
    public boolean hasCycle (ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
    }

}