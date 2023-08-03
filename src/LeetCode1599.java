import java.util.Map;

public class LeetCode1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int currentWaitPeople = 0;
        int cost = -1;
        int minTurn = 1;
        int turn = 1;
        int totalPeople = 0;
        for (int customer : customers) {
            currentWaitPeople += customer;
            if (currentWaitPeople >= 4) {
                currentWaitPeople -= 4;
                totalPeople += 4;
            } else {
                totalPeople += currentWaitPeople;
                currentWaitPeople = 0;
            }

            int currentCost = totalPeople * boardingCost - turn * runningCost;
            if (currentCost > cost) {
                minTurn = turn;
                cost = currentCost;
            }

            turn += 1;
        }
        while (currentWaitPeople > 0) {
            if (currentWaitPeople >= 4) {
                currentWaitPeople -= 4;
                totalPeople += 4;
            } else {
                totalPeople += currentWaitPeople;
                currentWaitPeople = 0;
            }
            int currentCost = totalPeople * boardingCost - turn * runningCost;
            if (currentCost > cost) {
                minTurn = turn;
                cost = currentCost;
            }
            turn += 1;
        }


        return cost <= 0 ? -1 : minTurn;
    }

    public static void main(String[] args) {
        LeetCode1599 t = new LeetCode1599();
        int[] custom = new int[]{2};
        System.out.println(t.minOperationsMaxProfit(custom, 2, 4));

    }

}
