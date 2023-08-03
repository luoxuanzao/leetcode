import javafx.util.Pair;

import java.util.HashMap;

public class LeetCode460 {

//    class LFUCache {
//
//        class Node {
//            public int frequent;
//            Node next;
//            Node pre;
//            int value;
//
//            public Node(int value) {
//                this.value = value;
//            }
//        }
//
//        HashMap<Integer, Pair<Node, Node>> frequent = new HashMap<>();
//        HashMap<Integer, Node> nodeMap = new HashMap<>();
//
//        int min = 0;
//
//        public LFUCache(int capacity) {
//
//        }
//
//        public int get(int key) {
//            if (!nodeMap.containsKey(key)) {
//                return -1;
//            }
//
//            Node n = nodeMap.get(key);
//            int f = n.frequent;
//
//            if (n.pre != null) {
//                n.pre = n.next;
//            } else {
//                frequent.put(f, n.next);
//            }
//
//            if (n.next != null) {
//                n.next.pre = n.pre;
//            }
//
//            n.frequent += 1;
//            Node head = frequent.get(n.frequent);
//            n.next = head;
//            frequent.put(n.frequent, n);
//
//            return head.value;
//        }
//
//        public void put(int key, int value) {
//            min = 1;
//            Node newNode = new Node(value);
//            nodeMap.put(key, newNode);
//            Node head = frequent.get(min);
//            newNode.next = head;
//            frequent.put(min, newNode);
//
//
//        }
//    }

}
