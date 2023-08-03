public class LeetCode2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        String event1Start = event1[0];
        String event1End = event1[1];
        String event2Start = event2[0];
        String event2End = event2[1];
        int start1 = Integer.parseInt(event1Start.split(":")[0]) * 60 + Integer.parseInt(event1Start.split(":")[1]);
        int start2 = Integer.parseInt(event2Start.split(":")[0]) * 60 + Integer.parseInt(event2Start.split(":")[1]);
        int end1 = Integer.parseInt(event1End.split(":")[0]) * 60 + Integer.parseInt(event1End.split(":")[1]);
        int end2 = Integer.parseInt(event2End.split(":")[0]) * 60 + Integer.parseInt(event2End.split(":")[1]);
        return start1 > end2 || start2 > end1;
    }
}
