import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class LeetCode2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> item = new ArrayList<>();
            item.add(entry.getKey());
            item.add(entry.getValue());
            result.add(item);
        }
        result.sort(Comparator.comparingInt(o -> o.get(0)));
        return result;
    }

    public static void main(String[] args) {
        String fileName = args[0];
        try {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            // 随机行顺序进行数据处理
            lines.forEach(System.out::println);
        } catch (IOException ignored) {
        }
    }
}
