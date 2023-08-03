import java.util.ArrayList;

public class LeetCode1106 {

    public boolean parseBoolExpr(String expression) {
        return calException(expression);
    }

    public boolean calException(String expression) {
        char first = expression.charAt(0);
        switch (first) {
            case 't':
                return true;
            case '!':
                return calNot(expression);
            case '&':
                return calAnd(expression);
            case '|':
                return calOr(expression);
            default:
                return false;
        }
    }

    private boolean calNot(String expression) {
        String subExpression = expression.substring(2, expression.length()-1);
        return !parseBoolExpr(subExpression);
    }

    private boolean calAnd(String expression) {
        ArrayList<String> expressions = matchExpression(expression.substring(2, expression.length()-1));
        for (String s : expressions) {
            if (!parseBoolExpr(s)) {
                return false;
            }
        }
        return true;
    }

    private boolean calOr(String expression) {
        ArrayList<String> expressions = matchExpression(expression.substring(2, expression.length()-1));
        for (String s : expressions) {
            if (parseBoolExpr(s)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> matchExpression(String expression) {
        // !(),t,|() 把这些子expression提取出来
        ArrayList<String> expressions = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '!':
                case '&':
                case '|': {
                    int j = i + 2;
                    int leftNum = 1;
                    while (j < expression.length() && leftNum != 0) {
                        if (expression.charAt(j) == '(') {
                            leftNum++;
                        } else if (expression.charAt(j) == ')') {
                            leftNum--;
                        }
                        j++;
                    }
                    expressions.add(expression.substring(i, j));
                    i = j;
                    break;
                }
                case 'f':
                case 't': {
                    expressions.add(expression.substring(i, i + 1));
                    break;
                }
                default:
                    break;
            }
        }
        return expressions;
    }

    public static void main(String[] args) {
        LeetCode1106 test = new LeetCode1106();
        System.out.println(test.parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}
