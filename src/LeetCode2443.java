public class LeetCode2443 {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = num; i > num / 2; i++) {
            if(i + reverse(i) == num){
                return true;
            }
        }
        return false;
    }

    public int reverse(int num){
        String n = String.valueOf(num);
        return Integer.parseInt(new StringBuilder(n).reverse().toString());
    }
}
