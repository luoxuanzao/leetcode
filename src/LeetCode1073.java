import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int resultLength = Math.max(arr1.length, arr2.length) + 3;
        int[] result = new int[resultLength];
        int[] flag = new int[resultLength];
        int index = 0;

        Arrays.sort(flag);

        int temp = 0;
        for (; index < resultLength - 1; index++) {
            int add = flag[index];
            if (arr1.length - 1 - index >= 0) {
                add += arr1[arr1.length - 1 - index];
            }
            if (arr2.length - 1 - index >= 0) {
                add += arr2[arr2.length - 1 - index];
            }


            if (add < 0) {
                flag[index + 1] -= (add - 1) / 2;
            } else {
                if (add / 2 != 0) {
                    flag[index + 1] -= add / 2;
                }

            }
            result[index] = Math.abs(add % 2);

        }

        int newIndex = result.length - 1;
        while (result[newIndex] == 0) {
            newIndex--;
        }

        int[] ans = new int[newIndex + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result[newIndex];
            newIndex--;
        }


        return ans;
    }


    public static void main(String[] args) {
        LeetCode1073 main = new LeetCode1073();
        main.addNegabinary(new int[]{1, 0, 1}, new int[]{1, 0, 1});
    }


}
