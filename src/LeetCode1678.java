public class LeetCode1678 {

    public String interpret(String command) {
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < command.length()) {
            if (command.charAt(index) == 'G') {
                stringBuilder.append("G");
            } else if (command.substring(index, index + 2).equals("()")) {
                stringBuilder.append("o");
                index++;
            } else {
                stringBuilder.append("al");
                index += 3;
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode1678 test = new LeetCode1678();
        System.out.println(test.interpret("G()()()()(al)"));
    }
}
