public class LeetCode6214 {
    public boolean haveConflict(String[] event1, String[] event2) {
        if(getTime(event1[0]) > getTime(event2[1]) || getTime(event1[1]) < getTime(event2[0])){
            return false;
        }

        return true;
    }

    public int getTime(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        return h * 60 + m;
    }

    public static void main(String[] args) {
        System.out.println("01:01".substring(0, 2));
    }
}
