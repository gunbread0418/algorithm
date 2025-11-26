import java.util.*;
import java.io.*;

/*
 * 2차원 에서는 부모를 어떻게 표현하지 ?? 
 * 
 * 나중에는 물로 변한 부분만 큐에 따로 넣어서 그 부분만 하기 
 * 처음부터 물인데 주변에 X가 있는 부분만 하기엔 너무 복잡한가 ?
 */

class Point{
	int r;
	int c;
	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int R,C;
	static char[][] matrix;
	static int[][] parent;
	static boolean[][] willMelt;
	// 처음에 자기 자신이 부모라는 것을 어떻게 표현하지 ?
	// R*C 칸의 개수 1행 5열과 5행 1열이 달라야 하는데 어떻게 다르게 하지 ?
	// R*C+C
	static Deque<Point> q = new ArrayDeque<>();
	static Deque<Point> changeWaterQ = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		matrix = new char[R+1][C+1];
		parent = new int[R+1][C+1];
		willMelt = new boolean[R+1][C+1];
		Point L1 = null , L2 = null; 
		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				char a = str.charAt(j-1); 
				parent[i][j] = (i-1)*C + j;
				matrix[i][j] = a;
				if(a=='L') {
					if(L1==null) {
						L1 = new Point(i,j);
					}
					else L2 = new Point(i,j);
					matrix[i][j] = '.';
				}
			}
		}
		// 1일차 돌리기
		int count = 1;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(matrix[i][j]=='.') {
					for (int k = 0; k < 4; k++) {
						int rr = dr[k] + i;
						int cc = dc[k] + j;
						if(rr<=0||cc<=0||rr>R||cc>C) continue;
						if(matrix[rr][cc]=='.') union(i,j,rr,cc);
						else if(matrix[rr][cc]=='X'&& !willMelt[rr][cc]) {
							changeWaterQ.add(new Point(rr,cc));
							willMelt[rr][cc] = true;
						}
					}
				}
			}
		}
		if(find(L1.r,L1.c)==find(L2.r,L2.c)) {
			System.out.print(count);
			return ;
		}
		while(true) {
//			System.out.println("ㅋ");

			while(!changeWaterQ.isEmpty()) {
				Point p = changeWaterQ.poll();
				matrix[p.r][p.c] = '.';
				q.add(p);
			}
			while(!q.isEmpty()) {
				Point p = q.poll();
				for (int k = 0; k < 4; k++) {
					int rr = dr[k] + p.r;
					int cc = dc[k] + p.c;
					if(rr<=0||cc<=0||rr>R||cc>C/*||matrix[rr][cc]=='.'*/) continue;
					if(matrix[rr][cc]=='.') union(p.r,p.c,rr,cc);
					else if(matrix[rr][cc]=='X'&& !willMelt[rr][cc]) {
						changeWaterQ.add(new Point(rr,cc));
						willMelt[rr][cc] = true;
					}
				}
			}
//			System.out.println();
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(matrix[i][j]);
//				}
//				System.out.println();
//			}
			if(find(L1.r,L1.c)==find(L2.r,L2.c)||changeWaterQ.size()==0) {
				System.out.print(count);
				return ;
			}
			count ++;

		}
	}
	
	static int dr[] = {0,1,-1,0};
	static int dc[] = {1,0,0,-1};
	
	static void bfs() {
		
	}
	
	static int find(int r, int c) {
		int a = parent[r][c];
		int rr = (a-1)/C+1;
		int cc = (a-1)%C+1;
		if(parent[r][c]==((r-1)*C+c)) return (r-1)*C+c;
		else return parent[r][c] = find(rr,cc);
	}
	
	static boolean union(int r1, int c1, int r2, int c2) {
		int root1 = find(r1,c1);
		int root2 = find(r2,c2);
		
		int rr1 = (root1-1)/C+1;
		int cc1 = (root1-1)%C+1;
		int rr2 = root2/C;
		int cc2 = root2%C;
		
		if(root1==root2) return false;
		parent[rr1][cc1] = root2;
		
		return true;
	}
	
	
	
}
