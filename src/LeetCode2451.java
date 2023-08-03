import java.util.*;

public class LeetCode2451 {
    public String oddString(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String key = transform2Char(word);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(word);
            map.put(key, value);

        }
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            if (stringListEntry.getValue().size() == 1) {
                return stringListEntry.getValue().get(0);
            }
        }
        return null;
    }

    public String transform2Char(String str) {
        char[] chars = new char[str.length() - 1];
        for (int i = 0; i < str.length() - 1; i++) {
            chars[i] = (char) (str.charAt(i + 1) - str.charAt(i));
        }
        return new String(chars);
    }

}
