import java.util.HashMap;


class Solution {
    public class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;

        }
    }
    HashMap<Node ,Node> rand=new HashMap<>();

    /**
     * 深拷贝带随机指针的链表
     *
     * 我的思路 一次循环复制好链表 并用哈希表一一对应
     * 第二次循环 利用哈希表确定随机指针
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node temp=head;
        Node dummy=new Node(0);
        Node first=new Node(head.val);
        dummy.next=first;
        rand.put(temp,first);
        while (temp.next!=null){
            first.next=new Node(temp.next.val);
            rand.put(temp,first);
            temp=temp.next;
            first=first.next;
        }
        rand.put(temp,first);
        temp=head;
        first=dummy.next;
        while (temp!=null){
            first.random=rand.get(temp.random);
            temp=temp.next;
            first=first.next;
        }

        return dummy.next;
    }

    /**
     * 三次循环 省去哈希表 把新的节点都加在原来节点后面  最后用一次循环恢复
     * @param head
     * @return
     */
    public Node copy_randomlist(Node head){
        Node dummt=new Node(0);
        dummt.next=head;
        while(head!=null){
            //所有的节点都复制一遍加到旧节点后面
            Node temp=head.next;
            head.next=new Node(head.val);
            head=head.next;
            head.next=temp;
            head=head.next;
        }
        head=dummt.next;
        while(head!=null){
            //更新了random
            Node temp=head.random;
            head=head.next;
            head.random=temp==null?null:temp.next;
            head=head.next;
        }
        head=dummt.next;
        Node result=new Node(0);
        Node newHead=head.next;
        result.next=newHead;
        while(head!=null){
            head.next=head.next.next;
            newHead.next=newHead.next==null?null:newHead.next.next;
            head=head.next;
            newHead=newHead.next;
        }
        return result.next;
    }
    public Node[] generate(int[] nums){
        Node[] xixi = new Node[nums.length];
        for(int i=0;i<nums.length;i++){
            xixi[i]=new Node(nums[i]);
        }
        for(int i=0;i<nums.length-1;i++){
            xixi[i].next=xixi[i+1];
        }
        xixi[nums.length-1].next=null;
        return xixi;
    }

    public static void main(String[] args) {
        Solution test=new Solution();
        int []nums=new int[]{7,13,11,10,1};
        Node[]xixi=test.generate(nums);
        xixi[0].random=null;
        xixi[1].random=xixi[0];
        xixi[2].random=xixi[4];
        xixi[3].random=xixi[2];
        xixi[4].random=xixi[1];
        Node result=test.copyRandomList(xixi[0]);
        System.out.println("123");
    }

}