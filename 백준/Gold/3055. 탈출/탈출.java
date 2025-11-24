import java.util.*;
import java.io.*;

class Point{
    int x;
    int y;
    int dist;
    Point(int x, int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};
    static char[][] matrix;
    static int[][] matrix2;
    static boolean[][] isVisited;
    static boolean[][] isVisited2;
    static int R,C;
    static Deque<Point> queue = new ArrayDeque<>();
    static Deque<Point> queue2 = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        matrix = new char[R][C];
        matrix2 = new int[R][C]; // 물을 위한 배열
        isVisited = new boolean[R][C];
        isVisited2 = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < C; j++) {
               matrix[i][j] = str.charAt(j);
               if(matrix[i][j] == 'S'){
                   queue.add(new Point(i,j,0));
                   matrix[i][j] = '.';
                   isVisited[i][j] = true;
               }else if(matrix[i][j] =='*') {
                   queue2.add(new Point(i,j,0));
                   isVisited2[i][j] = true;
               }
            }
        }
        int result =bfs();
        if(result==-1){
            System.out.print("KAKTUS");
        }else{
            System.out.println(result);
        }

    }
    static int bfs(){
        int count = 0;
        int count2 = 0;
        while(!queue2.isEmpty()){
            Point water = queue2.poll();
            for (int i = 0; i < 4; i++) {
                int x = water.x+dr[i];
                int y = water.y+dc[i];
                if(x<0||y<0||x>=R||y>=C||matrix[x][y]!='.') continue;
                if(isVisited2[x][y] == true) continue;
                queue2.add(new Point(x,y,water.dist+1));
                matrix[x][y] = '*';
                matrix2[x][y] = water.dist+1;
                isVisited2[x][y] = true;
            }
        }
        while(!queue.isEmpty()){ // 고슴도치가 비버의 굴로 들어가야하니까 고슴도치 큐로 판단
            Point dochi = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dochi.x+dr[i];
                int y = dochi.y+dc[i];
                if(x<0||y<0||x>=R||y>=C||matrix[x][y]=='X') continue;
                if(matrix[x][y]=='D') return dochi.dist+1;
                if(isVisited[x][y] == true) continue;
                if(matrix[x][y]=='*'){
                    if(!(matrix2[x][y]>dochi.dist+1)) continue;
                }
                //matrix[x][y] = '*';
                queue.add(new Point(x,y, dochi.dist+1));
                isVisited[x][y] = true;
            }
        }
        return -1;
    }
}
