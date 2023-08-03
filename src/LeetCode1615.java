import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) {
            return 0;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>(16);
        for (int[] road : roads) {
            Set<Integer> set1 = map.getOrDefault(road[0], new HashSet<>());
            set1.add(road[1]);

            Set<Integer> set2 = map.getOrDefault(road[1], new HashSet<>());
            set2.add(road[0]);

            map.put(road[0], set1);
            map.put(road[1], set2);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ans = 0;
                if (map.containsKey(i) && map.containsKey(j)) {
                    if (map.get(i).contains(j)) {
                        ans = map.get(i).size() + map.get(j).size() - 1;
                    } else {
                        ans = map.get(i).size() + map.get(j).size();
                    }
                    result = Math.max(result, ans);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        LeetCode1615 test = new LeetCode1615();
        System.out.println(test.maximalNetworkRank(6, new int[][]{{2, 4}}));
    }
}
