import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

class Solution {
    Map<Integer,List<String>> map= new HashMap<Integer, List<String>>();

    /**
     * 括号生成  生成 n 对有效括号
     * 动态规划  n对括号 可以由（ n-1对括号）组成 也可以由（n-i对括号）（i对括号）组成
     * 算好的n存到哈希表中
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        return help(n);
    }
    public List<String> help(int n){
       List<String> temp=new ArrayList<>();
       if(map.containsKey(n))return map.get(n);
       if(n<=0){
           temp.add("");
           return temp;
       }
       if(n==1){
           temp.add("()");
           map.put(1,temp);
            return temp;
       }else {
           List<String> head;
           List<String> tail;
           List<String> mid;
           for(int i=1;i<((n/2)+1);i++){
               head=help(i);
               tail=help(n-i);
               mid=help(n-1);
               for(String a:head){
                   for(String b:tail ){
                       if(!temp.contains(a+b)){
                           temp.add(a+b);
                       }
                       if(!temp.contains(b+a)){
                           temp.add(b+a);
                       }
                   }
               }
               for(String k:mid){
                   if(!temp.contains("("+k+")")){
                       temp.add("("+k+")");
                   }
               }
           }
           map.put(n,temp);
           return temp;
       }
    }

    public static void main(String[] args) {
        Solution test=new Solution();
        for (String s:test.generateParenthesis(1)
             ) {
            System.out.print(s+" ");
        }
        System.out.println();
        for (String s:test.generateParenthesis(2)
        ) {
            System.out.print(s+" ");
        }
        System.out.println();
        for (String s:test.generateParenthesis(3)
        ) {
            System.out.print(s+" ");
        }
        System.out.println();
        for (String s:test.generateParenthesis(4)
        ) {
            System.out.print(s+" ");
        }
    }
}
//["(()(()))","()(())()"]
//[,"(()(()))","(())(())"]
//["()()()()","(()()())","()(()())","((()()))","(()())()","()()(())","(()(()))","()(())()","()((()))","(((())))","((()))()","()(())()","((())())","(())()()"]