import java.util.*;

public class LeetCode2662 {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        long t = (long) target[0] << 32 | target[1];
        long s = (long) start[0] << 32 | start[1];

        Set<Long> vis = new HashSet<>();
        Map<Long, Long> dis = new HashMap<>();
        dis.put(t, Long.MAX_VALUE);
        dis.put(s, 0L);
        PriorityQueue<long[]> p = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        p.add(new long[]{0, s});

        while (!p.isEmpty()) {
            long[] peek = p.poll();

            long v = peek[1];
            long d = peek[0];
            if(vis.contains(v)){
                continue;
            }
            vis.add(v);


            if (v == t) {
                return (int) d;
            }

            int x = (int) (v >> 32);
            int y = (int) (v & Integer.MAX_VALUE);
            if (d + target[0] - x + target[1] - y < dis.get(t)) {
                dis.put(t, d + target[0] - x + target[1] - y);
                p.add(new long[]{d + target[0] - x + target[1] - y, t});
            }


            for (int[] specialRoad : specialRoads) {
                int startX = specialRoad[0];
                int startY = specialRoad[1];
                int endX = specialRoad[2];
                int endY = specialRoad[3];
                int cost = specialRoad[4];

                long temp = (long) endX << 32 | endY;
                long distance = d + Math.abs(startX - x) + Math.abs(startY - y) + cost;
                if (distance < dis.getOrDefault(temp, Long.MAX_VALUE)) {
                    dis.put(temp, distance);
                    p.add(new long[]{distance, temp});
                }
            }
        }
        return -1;
    }
}
