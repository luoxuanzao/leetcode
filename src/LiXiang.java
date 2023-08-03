import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LiXiang {
    int[] nums;
    Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();

    int maxLength = 0;
    ArrayList<Integer> result = null;

    public void solution() {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(",");
        int length = input.length;
        nums = new int[length];
        int[][] dp = new int[length][2];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);

            ArrayList<ArrayList<Integer>> sub = new ArrayList<>();
            ArrayList<Integer> downLists = new ArrayList<>();
            downLists.add(nums[i]);

            ArrayList<Integer> upLists = new ArrayList<>();
            upLists.add(nums[i]);

            sub.add(downLists);
            sub.add(upLists);

            map.put(i, sub);
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        for (int i = 1; i < length; i++) {
            int upIndex = -1;
            int downIndex = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    if (dp[j][1] + 1 > dp[i][0]) {
                        upIndex = j;
                        dp[i][0] = dp[j][1] + 1;
                    }

                } else if (nums[j] < nums[i]) {
                    if (dp[j][0] + 1 > dp[i][1]) {
                        downIndex = j;
                        dp[i][1] = dp[j][0] + 1;
                    }
                }
            }

            ArrayList<Integer> newUpList = new ArrayList<>();
            ArrayList<Integer> newDownList = new ArrayList<>();

            if (downIndex != -1) {
                ArrayList<Integer> downList = map.get(downIndex).get(0);
                newUpList.addAll(downList);
            }

            if (upIndex != -1) {
                ArrayList<Integer> upList = map.get(upIndex).get(1);
                newDownList.addAll(upList);

            }


            newUpList.add(nums[i]);
            newDownList.add(nums[i]);

            ArrayList<ArrayList<Integer>> newSub = new ArrayList<>();
            newSub.add(newDownList);
            newSub.add(newUpList);
            map.put(i, newSub);

            if (dp[i][0] > maxLength) {
                result = newDownList;
                maxLength = dp[i][0];
            }
            if (dp[i][1] > maxLength) {
                result = newUpList;
                maxLength = dp[i][1];
            }

        }


        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < result.size() - 1; i++) {
            ans.append(result.get(i)).append(",");
        }
        ans.append(result.get(result.size() - 1));
        System.out.println(ans
        );

    }


}
