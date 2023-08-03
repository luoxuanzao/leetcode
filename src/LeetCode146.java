import java.util.*;

public class LeetCode146 {


    class LRUCache {
        int capacity;
        Map<Integer, Integer> map;
        Deque<Integer> deque;
        int count = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            deque = new ArrayDeque<>();
            map = new HashMap<>();

        }

        public int get(int key) {
            if (!this.map.containsKey(key)) {
                return -1;
            }
            deque.remove(key);
            deque.addLast(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                deque.remove(key);
                deque.addLast(key);
                map.put(key,value);
            } else {
                if (count < this.capacity) {
                    deque.addLast(key);
                    map.put(key, value);
                    count += 1;
                } else {
                    int removeKey = deque.pop();
                    map.remove(removeKey);
                    map.put(key, value);
                    deque.addLast(key);
                }
            }
        }
    }

}
