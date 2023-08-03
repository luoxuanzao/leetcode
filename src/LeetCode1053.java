public class LeetCode1053 {
    public int[] prevPermOpt1(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = -1;
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i] && arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            if (max > 0) {
                arr[index] += arr[i];
                arr[i] = arr[index] - arr[i];
                arr[index] = arr[index] - arr[i];
                return arr;
            }
        }
        return arr;
    }
}
