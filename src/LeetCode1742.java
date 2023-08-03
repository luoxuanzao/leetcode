import java.util.HashMap;
import java.util.Map;

public class LeetCode1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int num = store.getOrDefault(calNum(i), 0) + 1;
            ans = Math.max(ans, num);
            store.put(calNum(i), num);
        }
        return ans;
    }

    public int calNum(int c) {
        int ans = 0;
        while (c > 0) {
            ans += c % 10;
            c = c / 10;
        }
        return ans;
    }
}
