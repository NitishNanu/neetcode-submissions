class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        if(fresh == 0) return 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int total=0;
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : dir){
                    int nr = r+d[0];
                    int nc = c+d[1];

                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc] == 1){
                        q.offer(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            total++;
        }
        return fresh !=0 ? -1 : total;
    }
}
