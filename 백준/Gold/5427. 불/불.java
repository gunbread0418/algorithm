import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    int time;
    Point(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}
public class Main {
    static int R, C;
    static char[][] matrix;
    static int[][] matrix2;
    static Deque<Point> q;
    static boolean isVisited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int T0 = 0; T0 < T; T0++) {
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            matrix = new char[R][C];
            matrix2 = new int[R][C]; // 불의 퍼진 정도를 담을 배열
            for(int i=0; i<R; i++) {
                Arrays.fill(matrix2[i], Integer.MAX_VALUE);
            }
            isVisited = new boolean[R][C];
            q = new ArrayDeque<>();
            Point p = null;
            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    char a = line.charAt(j);
                    if (a == '@') {
                        p = new Point(i, j, 0);
                    } else if (a == '*') {
                        isVisited[i][j] = true;
                        matrix2[i][j] = 0;
                        q.add(new Point(i, j, 0));
                    }
                    matrix[i][j] = a;
                }
            }
            bfs1();
            isVisited = new boolean[R][C];
            isVisited[p.r][p.c] = true;
            q.add(p);
            int result = bfs();
            if (result == 0) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static void bfs1() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            matrix2[p.r][p.c] = p.time;
            for (int i = 0; i < 4; i++) {
                int r = p.r + dr[i];
                int c = p.c + dc[i];
                if (r < 0 || c < 0 || r >= R || c >= C || matrix[r][c] == '#') continue;
                if (isVisited[r][c]) continue;
                isVisited[r][c] = true;
                q.add(new Point(r, c, p.time + 1));

            }
        }
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = p.r + dr[i];
                int c = p.c + dc[i];
                if (r < 0 || c < 0 || r >= R || c >= C) {
                    return p.time + 1;
                }
                if (matrix[r][c] == '#') continue;
                if (isVisited[r][c]) continue;
                if (matrix2[r][c] <= p.time + 1) continue;
                isVisited[r][c] = true;
                q.add(new Point(r, c, p.time + 1));
            }
        }
        return 0;
    }
}