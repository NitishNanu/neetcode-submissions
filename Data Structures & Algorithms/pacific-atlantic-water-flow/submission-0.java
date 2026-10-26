class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> pq=new LinkedList<>();
        Queue<int[]> dq=new LinkedList<>();
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0;i<n;i++){
            pacific[i][0]=true;
            pq.offer(new int[]{i,0});
            atlantic[i][m-1]=true;
            dq.offer(new int[]{i,m-1});
        }

        for(int j=0;j<m;j++){
            if(!pacific[0][j]){
                pacific[0][j]=true;
                pq.offer(new int[]{0,j});
            }
            if(!atlantic[n-1][j]){
                atlantic[n-1][j]=true;
                dq.offer(new int[]{n-1,j});
            }
        }

        bfs(heights,n,m,pq,pacific);
        bfs(heights,n,m,dq,atlantic);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void bfs(int[][] h, int n, int m, Queue<int[]> q, boolean[][] vis){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : dir){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && h[nr][nc] >= h[r][c]){
                    q.offer(new int[]{nr,nc});
                    vis[nr][nc]=true;
                }
            }
        }
    }
}
