import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1487 {
    public String[] getFolderNames(String[] names) {
        String[] result = new String[names.length];

        Map<String, Integer> fileMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!fileMap.containsKey(names[i])) {
                fileMap.put(names[i], 1);
                result[i] = names[i];
            } else {
                int index = fileMap.get(names[i]);
                String newName = names[i] + "(" + index + ")";
                while (fileMap.containsKey(newName)) {
                    index += 1;
                    newName = names[i] + "(" + index + ")";
                }
                fileMap.put(names[i], index + 1);
                fileMap.put(newName, 1);
                result[i] = newName;
            }
        }
        return result;
    }
}
