import java.util.*;

class Pt{
    int r;
    int c;
    int dist;
    Pt(int r, int c,int dist){
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}

class Solution {
    static ArrayDeque<Pt> q = new ArrayDeque<>();
    static int n,m;
    static boolean[][] isVisited;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        isVisited = new boolean[n][m];
        q.add(new Pt(0,0,1));
        isVisited[0][0] = true;
        
        answer = bfs(maps);
        return answer;
    }
    
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    
    static int bfs(int[][] maps){
        
        while(!q.isEmpty()){
            Pt p = q.poll();
            if(p.r==n-1&&p.c==m-1) return p.dist;
            for(int i = 0; i<4; i++){
                int rr = dr[i] + p.r;
                int cc = dc[i] + p.c;
                if(rr<0||cc<0||rr>=n||cc>=m||maps[rr][cc]==0) continue;
                if(isVisited[rr][cc]) continue;
                isVisited[rr][cc] = true;
                q.add(new Pt(rr,cc,p.dist+1));
                
            }
        }
        
        return -1;
    }
    
}