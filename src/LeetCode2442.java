import java.util.HashSet;
import java.util.Set;

public class LeetCode2442 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(reverse(num));
            set.add(num);
        }
        return set.size();
    }
    public int reverse(int num){
        String n = String.valueOf(num);
        return Integer.parseInt(new StringBuilder(n).reverse().toString());
    }
}
