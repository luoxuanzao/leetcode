import java.util.Arrays;
import java.util.Comparator;

class Solution {
    /**
     * 最大数 给定一个数组 把数组重新排列组成一个最大数
     * [3,30,34,5,9]
     * 9534330
     * String 中的 compareto可以用于字符串比较
     * arrays.sort(nums,new Comparator<String>（）{
     * @override
     * public int compare
     * }用于改写sort的比较器
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] strNum=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strNum[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String N1=o1+o2;
                String N2=o2+o1;
                return N2.compareTo(N1);
            }
        });
        if(strNum[0].equals("0"))return "0";
        StringBuilder result=new StringBuilder();
        for (String s : strNum) {
            result.append(s);
        }
        return result.toString();
        }

    public static void main(String[] args) {
        Solution test=new Solution();
        int [] a=new int[]{4,3,2,1};
        System.out.println(test.largestNumber(a));
    }


}