import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Node implements Comparable<Node> {

    int target;
    int val;

    Node(int target, int val) {
        this.target = target;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}
/*
가상의 노드 생성
 */
public class Main {
    static int n,m,r;
    static List<List<Node>> list= new ArrayList<>();
    static int[][] distance;
    static int[] items;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        distance = new int[n+1][n+1];
        items = new int[n+1];
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            items[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,val));
            list.get(b).add(new Node(a,val));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
            pq.add(new Node(i,0)); // 시작 지점은 1부터
            dijkstra(i);
        }
        int max = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            int a = 0;
            for(int j=1;j<=n;j++){
                if(distance[i][j]<=m){
                    a += items[j];
                }
            }
            if(a>max){
                max=a;
            }
        }
        System.out.print(max);

    }
    static void dijkstra(int start){
        distance[start][start]=0;
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int curTarget = n.target;
            int curDistance = n.val;
            //보류
            if(curDistance > distance[start][curTarget]) continue;

            for (Node node : list.get(curTarget)) {
                int newDistance = distance[start][curTarget]+node.val;
                int newTarget = node.target;
                if(newDistance < distance[start][newTarget]) {
                    distance[start][newTarget] = newDistance;
                    pq.add(new Node(newTarget,newDistance));
                }
            }
        }


    }
}