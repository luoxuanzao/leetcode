public class LeetCode1598 {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (int i = 0; i < logs.length; i++) {
            if ("../".equals(logs[i])) {
                depth = Math.max(0, depth - 1);
            } else if ("./".equals(logs[i])) {
                continue;
            } else {
                depth += 1;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        LeetCode1598 test = new LeetCode1598();
        String[] strings = new String[]{"d1/","d2/","./","d3/","../","d31/"};
        System.out.println(test.minOperations(strings));
    }
}
