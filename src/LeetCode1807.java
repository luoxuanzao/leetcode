import java.util.HashMap;
import java.util.List;

public class LeetCode1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                StringBuilder temp = new StringBuilder();
                i++;
                while (s.charAt(i) != ')') {
                    temp.append(s.charAt(i));
                    i++;
                }
                stringBuilder.append(map.getOrDefault(temp.toString(), "?"));
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
