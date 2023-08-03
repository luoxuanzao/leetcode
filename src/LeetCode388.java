import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LeetCode388 {
    public int lengthLongestPath(String input) {
        int currentDeep = 0;
        List<String> stack = new ArrayList<>();
        String[] dirs = input.split("\n");
        stack.add(dirs[0]);
        int result = 0;
        if(dirs[0].contains(".")){
            result = getLength(stack);
        }
        for (int i = 1; i < dirs.length; i++) {
            String currentDir = dirs[i];
            int index = 0;
            int deep = 0;
            while (index < currentDir.length() && currentDir.charAt(index) == '\t') {
                index++;
                deep++;
            }
            if (deep == currentDeep) {
                stack.remove(stack.size() - 1);
                stack.add(currentDir.substring(index));
            } else if (deep > currentDeep) {
                stack.add(currentDir.substring(index));
                currentDeep = deep;
            } else {
                for (int k = 0; k <= currentDeep - deep; k++) {
                    stack.remove(stack.size() - 1);
                }
                stack.add(currentDir.substring(index));
                currentDeep = deep;
            }
            if(currentDir.substring(index).contains(".")){
                result = Math.max(result, getLength(stack));
            }
        }
        return result;
    }

    public int getLength(List<String> dirs) {
        int result = 0;
        for (String s : dirs) {
            result += s.length();
        }
        return result + dirs.size() - 1;
    }

    public static void main(String[] args) {
        LeetCode388 test = new LeetCode388();
        test.lengthLongestPath("a\n\tb\n\t\tc");

    }
}
