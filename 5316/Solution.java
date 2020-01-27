
import javax.management.StringValueExp;
import java.util.LinkedList;
import java.util.List;

class Solution {
    /**
     * 竖直打印单词
     * 输入：s = "HOW ARE YOU"
     * 输出：["HAY","ORO","WEU"]
     * 解释：每个单词都应该竖直打印。
     *  "HAY"
     *  "ORO"
     *  "WEU"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/print-words-vertically
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public List<String> printVertically(String s) {
        String[] str=s.split(" ");
        int length=0;
        for(String a:str){
            if(a.length()>length){
                length=a.length();
            }
        }
        List<String> xixi =new LinkedList<>();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<length;i++){
            for(int k=0;k<str.length;k++){
            if(str[k].length()-1>=i){
                result.append(str[k].charAt(i));
            }else {
                result.append(" ");
            }
            }
            String temp=result.toString();
            int j=temp.length()-1;
            while (temp.charAt(j)==' '){
                j--;
            }

            xixi.add(temp.substring(0,j+1));
            result=new StringBuilder("");
        }
        return xixi;
    }


 
}