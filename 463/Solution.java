class Solution {
    /**
     * 岛屿的长度
     * 矩阵中一定有一个岛且岛中没有湖 只要看1是不是边界或者周围有没有0
     * 输入:
     * [[0,1,0,0],
     *  [1,1,1,0],
     *  [0,1,0,0],
     *  [1,1,0,0]]
     *
     * 输出: 16
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(i==0||grid[i-1][j]==0)count++;
                    if(i==grid.length-1||grid[i+1][j]==0)count++;
                    if(j==0||grid[i][j-1]==0)count++;
                    if(j==grid[0].length-1||grid[i][j+1]==0)count++;
                }
            }
        }
        return count;
    }
}