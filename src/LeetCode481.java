public class LeetCode481 {
    public int magicalString(int n) {

        if (n < 4) {
            return 1;
        }
        char[] nums = new char[n];

        nums[0] = '1';
        nums[1] = '2';
        nums[2] = '2';
        int count = 1;
        int pre = 2, next = 1;
        char turn = '2';
        while (pre < n-1) {
            next += 1;
            turn = change(turn);
            for (int i = 0; i < (nums[next] - '0') && pre + 1 < n; i++) {
                pre += 1;
                nums[pre] = turn;
                if (turn == '1') {
                    count += 1;
                }
            }
        }

        return count;
    }

    public char change(char turn) {
        if (turn == '1') {
            return '2';
        } else {
            return '1';
        }
    }

    public static void main(String[] args) {
        LeetCode481 test = new LeetCode481();
        test.magicalString(6);
    }
}
