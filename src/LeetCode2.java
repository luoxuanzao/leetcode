import java.util.ArrayList;
import java.util.List;

public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> nums = new ArrayList<>();
        int add = 0;
        ListNode point1 = l1;
        ListNode point2 = l2;

        while (point1 != null && point2 != null) {
            int sum = point1.val + point2.val + add;
            nums.add(sum % 10);
            add = sum / 10;

            point1 = point1.next;
            point2 = point2.next;
        }

        ListNode rest = point1 != null ? point1 : point2;
        while (rest != null) {
            int sum = rest.val + add;
            nums.add(sum % 10);
            add = sum / 10;
            rest = rest.next;
        }
        if (add != 0) {
            nums.add(add);
        }


        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (Integer num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }

        return dummy.next;
    }
}
