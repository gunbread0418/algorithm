import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static long arr[];
    static long tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        tree = new long[N*4];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0,N-1,1);

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if(a==1){
                arr[b-1] = c;
                update(0,N-1,1,b-1,c);
            }else{
                sb.append(multi(0,N-1,1,b-1,(int)c-1)).append("\n");
            }


        }
        System.out.println(sb);

    }


    static long init(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;

        return tree[node] = ((init(start,mid,node*2)%1000000007)*(init(mid+1,end,node*2+1)%1000000007))%1000000007;
    }

    static long multi(int start, int end, int node,int left,int right){

        if(left>end || right < start) return 1;

        if(left<= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return (multi(start,mid,node*2,left,right) * multi(mid+1,end,node*2+1,left,right))%1000000007;

    }

    static long update(int start, int end, int node, int idx, long c) {
        if (idx < start || idx > end) return tree[node];

        if (start == end) return tree[node] = c;
        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, c) * update(mid + 1, end, node * 2 + 1, idx, c)) % 1000000007;
    }
}
