import java.io.*;
import java.util.*;

class Point{
    int r,c;
    Point(int r,int c){
        this.r=r;
        this.c=c;
    }
}

public class Main {
    static int N,M;
    static int[][] matrix;
    static boolean[][] exCheese;
    static Deque<Point> cheeseQ = new ArrayDeque<>();
    static Deque<Point> q = new  ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        exCheese = new boolean[N][M];

        int cheeseCnt = 0; // 치즈 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a  = Integer.parseInt(st.nextToken());
                matrix[i][j] = a;
                if(a==1) cheeseCnt++;
                if(i==0||j==0||i==N-1||j==M-1){
                    if(a==0){
                        cheeseQ.add(new Point(i,j));
                    }
                }
            }
        }

        int time = 0;
        while(true){ // 치즈가 완전히 없어질 때까지
            //visited = new boolean[N][M];
            while(!cheeseQ.isEmpty()){
                Point p = cheeseQ.poll();
                if(exCheese[p.r][p.c])continue;
                q.add(new Point(p.r,p.c));
                exCheese[p.r][p.c] = true;
                bfs();
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(matrix[i][j]==1){
                        int count = 0;
                        for(int k=0;k<4;k++){
                            int r = i+dr[k];
                            int c = j+dc[k];
                            if(r<0||c<0||r>=N||c>=M)continue;
                            if(exCheese[r][c]) count++;
                        }
                        if(count>=2) {
                            matrix[i][j] = 0;
                            cheeseCnt--;
                            cheeseQ.add(new Point(i, j)); // 관리할 큐에 추가
                        }
                    }
                }
            }
            time++;
            if(cheeseCnt==0) break;
        }
        System.out.print(time);
    }
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    static void bfs(){
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int r = p.r+dr[i],c = p.c+dc[i];
                if(r<0||r>=N||c<0||c>=M||matrix[r][c]==1) continue;
                if(exCheese[r][c]) continue;
                exCheese[r][c] = true;
                q.add(new Point(r,c));
            }
        }
    }

}
