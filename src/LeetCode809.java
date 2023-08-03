public class LeetCode809 {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (check(s, word)) {
                count++;
            }
        }
        return count;
    }

    public boolean check(String s, String t) {
        int pointS = 0;
        int pointT = 0;
        while (pointS < s.length() && pointT < t.length()) {
            if (s.charAt(pointS) != t.charAt(pointT)) {
                return false;
            }
            int countS = count(s, pointS);
            int countT = count(t, pointT);
            if ((countS == countT) || (countS >= 3 && countS > countT)) {
                pointS += countS;
                pointT += countT;
            } else {
                return false;
            }
        }
        return pointS == s.length() && pointT == t.length();
    }

    public int count(String s, int index) {
        int count = 0;
        char c = s.charAt(index);
        while (index < s.length()) {
            if (s.charAt(index) == c) {
                count += 1;
            }else{
                break;
            }
            index += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode809 test = new LeetCode809();


        System.out.println(test.expressiveWords("nnnnnnzzzznnnnnnpppppfffff",


                new String[]{"nzznpf", "nnzznnpff", "nznpff", "nnznnpf", "nnznpff", "nzznppf", "nzznpff", "nnzznnppf"}));
    }
}
