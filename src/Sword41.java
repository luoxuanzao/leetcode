import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liuxuezhuo
 */
public class Sword41 {

    class MedianFinder {
        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;

        public MedianFinder() {
            queMin = new PriorityQueue<>((a, b) -> (b - a));
            queMax = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        }

        public void addNum(int num) {
            if (queMin.size() > queMax.size()) {
                queMin.add(num);
                queMax.add(queMin.poll());
            } else {
                queMax.add(num);
                queMin.add(queMax.poll());
            }
        }

        public double findMedian() {
            if (queMin.size() > queMax.size()) {
                return queMin.peek();
            } else {
                return (queMin.peek() + queMax.peek()) / 2.0;
            }
        }
    }

}
