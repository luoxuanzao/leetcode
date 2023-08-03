public class LeetCode86 {


    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(-1);
        ListNode moreDummy = new ListNode(-1);
        ListNode p = head;
        ListNode lessPoint = lessDummy;
        ListNode morePoint = moreDummy;


        while (p != null) {
            if (p.val < x) {
                lessPoint.next = p;
                lessPoint = lessPoint.next;
            } else {
                morePoint.next = p;
                morePoint = morePoint.next;
            }
            p = p.next;
        }

        lessPoint.next = moreDummy.next;
        morePoint.next = null;

        return lessDummy.next;
    }
}
