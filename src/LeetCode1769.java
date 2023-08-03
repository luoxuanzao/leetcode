public class LeetCode1769 {

    public int[] minOperations(String boxes) {
        int left = 0;
        int leftScore = 0;
        int right = 0;
        int rightScore = 0;
        char[] bits = boxes.toCharArray();
        int[] result = new int[bits.length];
        int distance = 1;
        for (int i = 1; i < bits.length; i++) {
            if (bits[i] == '1') {
                right += 1;
                rightScore += distance;
            }
            distance += 1;
        }
        result[0] = rightScore;
        for (int i = 1; i < bits.length; i++) {
            if (bits[i - 1] == '1') {
                left += 1;
            }
            leftScore += left;


            rightScore -= right;
            if (bits[i] == '1') {
                right -= 1;
            }
            result[i] = leftScore + rightScore;

        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1769 test = new LeetCode1769();
        int[] n = test.minOperations("110");
        int[] n1 = test.minOperations("001011");

        System.out.println(123);
    }
}
