public class Solution {
    /**
     * 迷宫
     * 由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。
     *
     * 给定球的起始位置，目的地和迷宫，判断球能否在目的地停下。
     *
     * 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
     *
     *  
     *
     * 示例 1:
     *
     * 输入 1: 迷宫由以下二维数组表示
     *
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 1 0
     * 1 1 0 1 1
     * 0 0 0 0 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-maze
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //深度优先搜索
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]])//已经访问过就返回false 不走回头路
            return false;
        if (start[0] == destination[0] && start[1] == destination[1])
            //到达目的地
            return true;
        visited[start[0]][start[1]] = true;//标记为访问过了
        int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
        while (r < maze[0].length && maze[start[0]][r] == 0) // right
            r++;
        if (dfs(maze, new int[] {start[0], r - 1}, destination, visited))
            return true;
        while (l >= 0 && maze[start[0]][l] == 0) //left
            l--;
        if (dfs(maze, new int[] {start[0], l + 1}, destination, visited))
            return true;
        while (u >= 0 && maze[u][start[1]] == 0) //up
            u--;
        if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited))
            return true;
        while (d < maze.length && maze[d][start[1]] == 0) //down
            d++;
        if (dfs(maze, new int[] {d - 1, start[1]}, destination, visited))
            return true;
        return false;
    }
}

