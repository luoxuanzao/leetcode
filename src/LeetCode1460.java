import java.util.HashMap;
import java.util.Map;

public class LeetCode1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            store.put(target[i], store.getOrDefault(target[i], 0) + 1);
            store.put(target[i], store.getOrDefault(arr[i], 0) - 1);
        }
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
