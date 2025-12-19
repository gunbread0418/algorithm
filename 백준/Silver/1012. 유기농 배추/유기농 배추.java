import java.io.*;
import java.util.*;

class Pt{
    int r ;
    int c ;
    Pt(int r,int c){
        this.r=r;
        this.c=c;
    }
}

public class Main {
    static int N,M,K;
    static char[][] matrix;
    static boolean[][] visited;
    static Deque<Pt> q = new  ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            matrix = new char[N][M];
            visited = new boolean[N][M];
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int c =  Integer.parseInt(st.nextToken());
                int r =  Integer.parseInt(st.nextToken());
                matrix[r][c] = 'a';
            }
            int ans = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(matrix[i][j]=='a'&&visited[i][j]==false) {
                        visited[i][j]=true;
                        q.add(new Pt(i,j));
                        ans++;
                        bfs();
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static void bfs(){
        while(!q.isEmpty()){
            Pt p = q.poll();
            for(int i=0;i<4;i++){
                int r = p.r+dr[i];
                int c = p.c+dc[i];
                if(r<0||c<0||r>=N||c>=M||matrix[r][c]!='a')continue;
                if(visited[r][c]) continue;
                visited[r][c]=true;
                q.add(new Pt(r,c));
            }
        }
    }
}
