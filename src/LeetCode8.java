public class LeetCode8 {
    public int myAtoi(String s) {
        boolean positive = true;
        s = s.trim();
        if(s.charAt(0) == '-'){
            positive = false;
            s = s.substring(1);
        }
        else if(s.charAt(0) == '+'){
            s = s.substring(1);
        }
        long result = 0;
        int index = 0;
        while(index < s.length() && (s.charAt(index) <= '9' && s.charAt(index) >= '0')){
            if(s.charAt(index) == '0' && result == 0){
                continue;
            }
            result *= 10;
            result += s.charAt(index) - '0';
            if(positive && result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(!positive && -result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return positive? (int) result : (int) -result;
    }
}
