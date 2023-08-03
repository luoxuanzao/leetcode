import java.util.*;

public class LeetCode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replace('!', ' ');
        paragraph = paragraph.replace('?', ' ');
        paragraph = paragraph.replace(';', ' ');
        paragraph = paragraph.replace('.', ' ');
        paragraph = paragraph.replace(',', ' ');
        paragraph = paragraph.replace('\'', ' ');
        String[] words = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (w.trim().length() > 0) {
                String target = w.trim().toLowerCase();
                Integer count = map.getOrDefault(target,0);
                map.put(target, count + 1);
            }
        }
        String result = "";
        Integer max = 0;
        Set<String> stringSet = new HashSet<>();
        Collections.addAll(stringSet, banned);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!stringSet.contains(entry.getKey()) && entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode819 test = new LeetCode819();
        System.out.println(test.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));


    }
}
