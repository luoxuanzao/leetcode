import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            priorityQueue.add(new int[]{values[i], labels[i]});
        }
        int currentCount = 0;
        while (currentCount < numWanted && !priorityQueue.isEmpty()) {
            int[] nums = priorityQueue.remove();
            if (map.getOrDefault(nums[1], 0) < useLimit) {
                map.merge(nums[1], 1, Integer::sum);
                result += nums[0];
                currentCount += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1090 main = new LeetCode1090();
        main.largestValsFromLabels(new int[]{5, 4, 3, 2, 1},
                new int[]{1, 3, 3, 3, 2},
                3,
                2);
    }
}
