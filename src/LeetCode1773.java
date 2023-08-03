import java.util.List;

public class LeetCode1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0, result = 0;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
            default:
                index = 3;
        }

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                result++;
            }
        }
        return result;
    }
}
