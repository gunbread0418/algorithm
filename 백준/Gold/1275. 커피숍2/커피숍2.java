import java.util.*;
import java.io.*;

public class Main {
    static int N,Q;
    static long arr[];
    static long tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[N*4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(0,N-1,1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if(x<y) sb.append(sum(0,N-1,1,x-1,y-1)).append("\n");
            else sb.append(sum(0,N-1,1,y-1,x-1)).append("\n");
            arr[a-1] = b;
            update(0,N-1,1,a-1,b);

        }
        System.out.println(sb);
    }

    static long init(int start,int end, int node){
        if(start==end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = init(start,mid,node*2)+init(mid+1,end,node*2+1);
    }

    static long sum(int start,int end,int node,int left,int right) {
        if (start > right || end < left) return 0L;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static long update(int start, int end ,int node, int idx, long val){
        if(idx<start||idx>end) return tree[node];
        if(start==end) return tree[node] = arr[start];
        int mid = (start+end)/2;

        return tree[node] = update(start,mid,node*2,idx,val) + update(mid+1,end,node*2+1,idx,val);


    }

}
