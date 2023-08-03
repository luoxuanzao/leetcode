import java.util.Deque;
import java.util.LinkedList;

public class LeetCode901 {

    class StockSpanner {
        Deque<int[]> stack;
        int index = -1;

        public StockSpanner() {
            stack = new LinkedList<>();
            stack.push(new int[]{-1, Integer.MAX_VALUE});
        }

        public int next(int price) {
            index++;
            while (!stack.isEmpty() && stack.peek()[1] <= price) {
                stack.pop();
            }
            int ret = 0;
            if (!stack.isEmpty()) {
                ret = index - stack.peek()[0];
            }
            stack.push(new int[]{index, price});

            return ret;
        }
    }

}
