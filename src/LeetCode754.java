public class LeetCode754 {


    public int reachNumber(int target) {
        target = Math.abs(target);
        int s = 0, n = 0;
        while (s < target || (s - target) % 2 == 1) {
            s += ++n;
        }
        return n;
    }

    public static void main(String[] args) {
        LeetCode754 test = new LeetCode754();
        System.out.println(test.reachNumber(2));
    }

}
