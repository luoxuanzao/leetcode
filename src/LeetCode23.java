import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }

        ListNode result = new ListNode();
        ListNode point = result;
        while (!priorityQueue.isEmpty()) {
            ListNode peek = priorityQueue.poll();
            if (peek.next != null) {
                priorityQueue.add(peek.next);
            }
            point.next = peek;
            point = point.next;
        }
        return result.next;
    }
}
