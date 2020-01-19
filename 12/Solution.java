
class Solution {

    /**
     * 数字转罗马字
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        char[] Roman_one=new char[]{'I','X','C','M'};
        char[] Roman_five=new char[]{'V','L','D'};

        int temp=0;
        String result="";
        for(int i=0;i<3;i++){
            if(num==0)break;
            temp=num%10;
            num=num/10;
            switch (temp){
                case 1:

            }
            if(temp>0&&temp<4){
                for(int j=0;j<temp;j++){
                    result=Roman_one[i]+result;
                }
            }else if(temp==4){
                result=Roman_one[i]+""+Roman_five[i]+result;
            }else if(temp>=5&&temp<9){

                for(int k=0;k<temp-5;k++){
                    result=Roman_one[i]+result;
                }
                result=Roman_five[i]+result;
            }
            else if(temp==9){
                result=Roman_one[i]+""+Roman_one[i+1]+result;
            }
        }
        if(num==0) return result;
        else {
            temp=num%10;
            for(int i=0;i<temp;i++){
                result=Roman_one[3]+result;
               }
            return result;
        }
    }


    public static void main(String[] args) {
        Solution test=new Solution();
        System.out.println(test.intToRoman(1994));
    }
}