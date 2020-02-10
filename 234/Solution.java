import java.util.Stack;

class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * 判断链表是不是回文
     * 头插法倒着复制链表
     * 然后一一比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null)return true;
        int size=1;
        ListNode tail=null;
        ListNode dummy=head;
        while(head!=null){
            size++;
            ListNode temp=tail;
            tail=new ListNode(head.val);
            tail.next=temp;
            head=head.next;
        }
        head=dummy;
        while(head!=null){
            if(head.val!=tail.val)return false;
            tail=tail.next;
            head=head.next;
        }
    return true;
    }

    public static void main(String[] args) {
        Solution test=new Solution();
        ListNode head=test.new ListNode(1);
        ListNode didi=head;
        head.next=test.new ListNode(0);
        head=head.next;
        head.next=test.new ListNode(1);
        System.out.println(test.isPalindrome(didi));
    }

}