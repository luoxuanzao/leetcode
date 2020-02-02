import java.util.Hashtable;
class LRUCache {
    //熟悉的cache 借鉴了助教的代码 思路正确 但是成功不了 因为中间有一个小小的bug

    //这里使用新的方法 利用双向链表加哈希表的方法实现
    //加入的节点或者再次使用的节点放到head的next节点  优先删除tail的前继节点
    //利用hash表检查是否存在这个节点 并且快速定位
    Hashtable<Integer,DLinkedlist> hashtable =new Hashtable();
    //双向链表加哈希表

    class DLinkedlist{
        DLinkedlist prev;
        DLinkedlist next;
        int key;
        int value;
        public DLinkedlist(int key,int value){
            this.key=key;
            this.value=value;
        }
        public DLinkedlist(){
        }
    }
    int size;
    int capacity;
    DLinkedlist head=new DLinkedlist();
    DLinkedlist tail=new DLinkedlist();

    public LRUCache(int capacity) {
        size=0;
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    public DLinkedlist add2head(DLinkedlist node){
        DLinkedlist first=head.next;
        first.prev=node;
        head.next=node;
        node.next=first;
        node.prev=head;
        hashtable.put(node.key,node);
        return node;
    }
    public DLinkedlist move2head(DLinkedlist node){
        DLinkedlist temp=delete(node);
        return add2head(temp);
    }
    public DLinkedlist delete(DLinkedlist node){
        hashtable.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        return node;
    }

    public int get(int key) {
        DLinkedlist getDlinked =hashtable.get(key);
        if(getDlinked==null)return -1;
        return move2head(getDlinked).value;
    }

    public void put(int key, int value) {
        DLinkedlist exist = hashtable.get(key);
        if (exist != null) {//在里面
            exist.value = value;
            move2head(exist);
        } else {
            if (size == capacity) {
                //容量bu够
               delete(tail.prev);
            }else {
                size++;
            }
            DLinkedlist newNode = new DLinkedlist(key, value);
            add2head(newNode);
        }
    }



    //以下是助教的思路 用时间戳加数组实现LRU 但是有一个问题  时间戳是获得当前时间 但是当程序运行很快时  两个节点获得的时间戳可能时相同的
    //在我自己的测试里  每次运行结果都可能不同 因为程序有时快有时慢
    //之前助教代码可以过测试是因为 没有短时间内同时检测两个LRU 所以时间戳不会出现相同的情况
    //这里想借鉴一下 python的sleep 企图用 Thread.sleep()强制让时间戳不相同 但是leetcode 调用方法时会报错 没有捕捉异常 本地跑跑还行
    //    class content{
//        int key;
//        int data;
//        Long timeline;
//        public void setTimes(){
//            timeline=System.currentTimeMillis()+1;
//        }
//    }
//    content [] store;
//
//    public LRUCache(int capacity) {
//        store=new content[capacity];
//    }
//
//    public int get(int key) {
//        for(int i=0;i<store.length;i++){
//            if(store[i]!=null) {
//                if (store[i].key == key) {
//                    store[i].setTimes();
//                    return store[i].data;
//                }
//            }
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        Long min=Long.MAX_VALUE;
//        int index=0;
//        for(int i=0;i<store.length;i++){
//            if(store[i]!=null){
//                if(store[i].key==key){
//                    store[i].data=value;
//                    store[i].setTimes();
//                    return;
//                }
//            }
//        }
//        for(int i=0;i<store.length;i++) {
//            if(store[i]==null){
//                store[i]=new content();
//                store[i].key=key;
//                store[i].data=value;
//                store[i].setTimes();
//                return;
//            }
//            if (min >= store[i].timeline) {
//                min = store[i].timeline;
//                index = i;
//            }
//        }
//        store[index].key=key;
//        store[index].data=value;
//        store[index].setTimes();
//    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */