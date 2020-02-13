class Solution {
    /**
     * 反转字符串 要求不能使用其他的数组 空间复杂度为 o（1）
     * 从两边向中间 交换数据
     * @param s
     */
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while(left<=right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}