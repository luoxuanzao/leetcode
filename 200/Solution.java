class Solution{
    /**
     * 岛屿的数量
     * 1 代表岛屿 相邻的1表示联通的岛屿
     * 方法1 用dfs 用两层for循环遍历矩阵 遇到一个1就上下左右深度搜索 把联通的1 全部改成0
     *
     * 方法2 并查集  之后补上
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
    int count=0;
    if(grid==null)return count;
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='1'){
                count++;
                dfs(grid,i,j);
            }
        }
    }
    return count;
    }
    public void dfs(char[][] grid,int i,int j){
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]=='0')return;
        grid[i][j]='0';
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }



}
