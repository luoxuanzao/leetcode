public class LeetCode868 {
    public int binaryGap(int n) {
        if (n == 0) {
            return 0;
        }
        String binary = Integer.toBinaryString(n);
        int index = 0;
        int result = 0;
        while (binary.charAt(index) != '1') {
            index++;
        }
        while (index < binary.length()) {
            int i = 1;
            while (index + i < binary.length() && binary.charAt(index + i) != '1') {
                i++;
            }
            if (index + i < binary.length()) {
                result = Math.max(result, i);
            } else {
                break;
            }
            index = index + i;
        }
        return result;

    }

    public static void main(String[] args) {
        LeetCode868 test = new LeetCode868();
        test.binaryGap(22);
    }
}
