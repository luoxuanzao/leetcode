class Solution {
    /**
     * 其实就是一个 26进制转10进制
     * 加的时候不用算pow 每次把结果乘以进制就可以了
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int result=0;
        int N=s.length();
        for(int i=0;i<N;i++){
            result= result*26+s.charAt(i)-'A'+1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.titleToNumber("AB"));
    }
}