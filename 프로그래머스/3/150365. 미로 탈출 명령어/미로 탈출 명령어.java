import java.util.*;


class Solution {
    static PriorityQueue<String> pq;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // n X m , 출발 위치 x,y 탈출지점 r,c  탈출거리 k 
        String answer = "";
        
        // isVisited 는 없어야 함 왔던길 또갈 수 있기에 대신 Point 의  cnt로 6이상인건 큐에 넣지 않음

        pq = new PriorityQueue<>();
        
        dfs(x-1,y-1,r-1,c-1,k,"",n,m);
        
        if(res!=null) answer = res;
        else answer = "impossible";
        
        return answer;
    }
    
    static String res = null;
    
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,-1,1,0};
    
    static void dfs(int x, int y, int r, int c, int k, String str,int n , int m){
        
        if(res != null) return;
        
        int remainDist = k - str.length();
        int shortestDist = Math.abs(x - r) + Math.abs(y - c);
        if (remainDist < shortestDist || (remainDist - shortestDist) % 2 != 0) {
        return;
        }
        
        if(x==r&&y==c&&str.length()==k) {
            res = str;
            return;
        }
        
        if(str.length()==k) return;
        
        for(int i = 0; i<4; i++){
            int rr = x + dr[i];
            int cc = y + dc[i];
            String tmp = "";
            if(rr<0||cc<0||rr>=n||cc>=m) continue;
            if(i==0) tmp =  "d";
            else if(i==1) tmp = "l";
            else if(i==2) tmp = "r";
            else tmp = "u";
            dfs(rr,cc,r,c,k,str+tmp,n,m);
            
        }

            
    
        
    }
}