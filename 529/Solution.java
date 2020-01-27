
class Solution {
    char[][]result;
    boolean[][] visited;

    /**
     * 扫雷游戏  模拟点击一次的效果
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        result=board;
        visited= new boolean[board.length][board[0].length];
        dfs(click);
        return result;
    }
    public  void dfs(int[]click){
            int line=click[0];
            int col=click[1];
            if(visited[line][col]){
                return;
            }else {
                if(result[line][col]=='M'){
                    result[line][col]='X';
                    visited[line][col]=true;
                    return ;
                }else if(result[line][col]=='E'){
                   testAround(click);
                }
            }
    }
    public int testAround(int[]click){
        int count=0;
        int line=click[0];
        int col=click[1];
        int up=line-1>=0?line-1:line;
        int down=line+1<result.length?line+1:line;
        int left=col-1>=0?col-1:col;
        int right=col+1<result[0].length?col+1:col;
        if(col!=0){
            count=result[line][left]=='M'?count+1:count;
        }
       if(col!=result[0].length-1) {
           count = result[line][right] == 'M' ? count + 1 : count;
       }
        if(line!=0){
            if(col!=0){
                count=result[up][left]=='M'?count+1:count;
            }
            if(col!=result[0].length-1){
                count=result[up][right]=='M'?count+1:count;
            }
            count=result[up][col]=='M'?count+1:count;

        }
        if(line!=result.length-1)
        {
            if(col!=0){
                count=result[down][left]=='M'?count+1:count;
            }
            if(col!=result[0].length-1){
                count=result[down][right]=='M'?count+1:count;
            }
            count=result[down][col]=='M'?count+1:count;
        }
        if(count==0){
            result[line][col]='B';
        }else {
            result[line][col]=(char)('0'+count);
            return 0;
        }
        dfs(new int[]{up,left});
        dfs(new int[]{up,right});
        dfs(new int[]{up,col});
        dfs(new int[]{line,left});
        dfs(new int[]{line,right});
        dfs(new int[]{down,left});
        dfs(new int[]{down,right});
        dfs(new int[]{down,col});
        return count;
    }

    public static void main(String[] args) {
        Solution test=new Solution();
        char[][] xixi=new char[][]{
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};


        test.updateBoard(xixi,new int[]{1,2});
        System.out.println("123");
    }


}