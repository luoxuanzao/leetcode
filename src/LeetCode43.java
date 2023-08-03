public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = result[i + j + 1] + n1 * n2;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < result.length) {
            stringBuilder.append(result[index]);
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode43 main = new LeetCode43();
        main.multiply("99", "99");
    }
}
