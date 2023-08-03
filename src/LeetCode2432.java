public class LeetCode2432 {
    public int hardestWorker(int n, int[][] logs) {

        int min = Integer.MIN_VALUE;
        int result = 0;
        int lastTime = 0;
        for (int[] log : logs) {
            int workTime = log[1] - lastTime;
            lastTime = log[1];
            if(workTime > min){
                min = workTime;
                result = log[0];
            }else if(workTime == min && log[0] < result){
                result = log[0];
            }
        }
        return result;
    }
}
