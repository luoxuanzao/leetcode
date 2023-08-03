import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode295 {

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

    public static void main(String[] args) {
        LeetCode295 leetCode295 = new LeetCode295();
        MedianFinder medianFinder = leetCode295.new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}
