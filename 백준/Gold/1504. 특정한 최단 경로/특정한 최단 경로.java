import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int target;
    int dist;
    Node(int target, int dist){
        this.target = target ;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o){
        return this.dist-o.dist;
    }
}

public class Main {
    static int N, E; // N은 정점의 개수 , E 는 간선의 개수
    static int[] dist,distV1,distV2; // 초기설정은 다 무한으로 해야 함
    static List<List<Node>> ll = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        distV1 = new int[N+1];
        distV2 = new int[N+1];
        for (int i = 0; i <= N; i++) {
            ll.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
            distV1[i] = Integer.MAX_VALUE;
            distV2[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            ll.get(a).add(new Node(b,dist));
            ll.get(b).add(new Node(a,dist));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dijkstra(1,dist);
        pq = new PriorityQueue<>();
        dijkstra(v1,distV1);
        pq = new PriorityQueue<>();
        dijkstra(v2,distV2);

        int p1 = dist[v1] + distV1[v2] + distV2[N];
        if(dist[v1]==Integer.MAX_VALUE||distV1[v2]==Integer.MAX_VALUE||distV2[N]==Integer.MAX_VALUE) p1 = Integer.MAX_VALUE;
        int p2 = dist[v2] + distV2[v1] + distV1[N];
        if(dist[v2]==Integer.MAX_VALUE||distV2[v1]==Integer.MAX_VALUE||distV1[N]==Integer.MAX_VALUE) p2 = Integer.MAX_VALUE;
        int result = Math.min(p1,p2);
        if(result==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);



    }

    static void dijkstra(int start,int[] distance){
        pq.add(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curTarget = cur.target;
            int curDist = cur.dist;

            if(distance[curTarget]<curDist) continue; // 이미 갱신된 경로이므로 더 긴 경로는 검사하지 않겠다.

            for(Node i : ll.get(curTarget)){
                int newTarget = i.target;
                int newDist = curDist + i.dist;
                if(newDist<distance[newTarget]){
                    distance[newTarget] = newDist;
                    pq.add(new Node(newTarget,newDist));
                }
            }
        }
    }

}
