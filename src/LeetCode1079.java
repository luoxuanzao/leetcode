import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LeetCode1079 {
//    Set<String> str = new HashSet<>();
//
//    boolean[] vis;
//
//    char[] letters;
//
//    public int numTilePossibilities(String tiles) {
//        letters = tiles.toCharArray();
//        vis = new boolean[tiles.length()];
//        backtrack(new ArrayList<>());
//        return str.size();
//    }
//
//
//    public void backtrack(List<Character> list) {
//        String s = list.stream().map(String::valueOf).collect(Collectors.joining());
//        if (s.length() != 0) {
//            str.add(s);
//        }
//
//        for (int i = 0; i < letters.length; i++) {
//            if (vis[i] || (i > 0 && letters[i] == letters[i - 1] && !vis[i - 1])) {
//                continue;
//            }
//            list.add(letters[i]);
//            vis[i] = true;
//            backtrack(list);
//            list.remove(list.size() - 1);
//            vis[i] = false;
//        }
//    }


    static int MX = 8;
    static int[][] C = new int[MX][MX];

    static {
        for (int i = 0; i < C.length; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i][j - 1];
            }
        }

    }

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            counter.merge(tiles.charAt(i), 1, Integer::sum);
        }
        int m = counter.size(), n = tiles.length();
        int[][] f = new int[m + 1][n + 1];
        f[0][0] = 1;
        int i = 1;


        for (Integer cnt : counter.values()) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= j && k <= cnt; k++) {
                    f[i][j] += f[i - 1][j - k] * C[j][k];
                }
            }
            i++;
        }
        int ans = 0;
        for (int j = 1; j <= n; j++) {
            ans += f[m][j];
        }
        return ans;

    }

    public static void main(String[] args) {

        Integer a = 123;
        Integer b = 231;
        System.out.println(Objects.equals(a, b));




    }
}
