import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 最长回文字符串
     *
     * @param s
     * @return
     */
    Map<String, String> memo = new HashMap<>();

    public String longestPalindrome(String s) {
//        String result=help(s);
//        if(result.length()==0)return String.valueOf(s.charAt(0));
//        else return result;
        boolean[][] ispa = new boolean[s.length()][s.length()];//用起始位置来记录这个字符串是否是回文
        String result = "";
        for (int len = 1; len <= s.length(); len++) {
            //从长度为1的字符串开始遍历
            for (int start = 0; start < s.length(); start++) {
                int end = len + start - 1;
                if (end >= s.length()) break;//如果越界就停止
                String sub = s.substring(start, end + 1);
                ispa[start][end] = (len == 1 || ((len == 2 || ispa[start + 1][end - 1]) && (s.charAt(start) == s.charAt(end))));
                //长度为1 或者首位相同（ 长度为2或者内部是一个回文）把矩阵设置为true
                if (ispa[start][end])
                    //如果是回文 看长度是不是变长了
                    result = (result.length() > len) ? result : s.substring(start, end + 1);
            }
        }
        return result;
    }

    
    //之前用的递归加哈希表（用来存已经是回文的字符串） 比循环加数组慢很多，虽然这个也算是暴力解法，不过也算是优化了暴力解法
    public String help(String s) {
        if(memo.containsKey(s))return memo.get(s);
        boolean test=false;
        if(s.length()==0)return "";
        if(s.length()==1){
            memo.put(s,s);
            return s;
        }
        if(s.charAt(0)==s.charAt(s.length()-1)){
            test=true;
        }
        if(test&&help(s.substring(1,s.length()-1)).length()==s.length()-2){
            memo.put(s,s);
            return s;
        }else {
            String result;
            String first= help(s.substring(0,s.length()-1));
            String second=help(s.substring(1));
            if(first.length()>second.length()){
                result=first;
            }else {
                result=second;
            }
            memo.put(s,result);
            return result;
        }
    }




    public static void main(String[] args) {
        Solution test=new Solution();
        System.out.println(test.longestPalindrome("babad"));
    }
}