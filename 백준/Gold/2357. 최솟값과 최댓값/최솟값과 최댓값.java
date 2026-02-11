import java.util.*;
import java.io.*;


public class Main {
    static int N, M; // N개의 정수 M 개의 쌍
    static int[] arr;
    static int[] treeMax;
    static int[] treeMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        treeMax = new int[N * 4];
        treeMin = new int[N * 4];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        initMax(0,N-1,1);
        initMin(0,N-1,1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            resultMin = Integer.MAX_VALUE;
            resultMax = Integer.MIN_VALUE;

            find(0,N-1,1,a-1,b-1);

            sb.append(resultMin).append(" ").append(resultMax).append("\n");
        }
        System.out.println(sb);
    }

    static int resultMax;
    static int resultMin;

    static int initMax(int start, int end, int node) {

        if(start==end) return treeMax[node] = arr[start];

        int mid = (start+end)/2;

        return treeMax[node] = Math.max(initMax(start,mid,node*2),initMax(mid+1,end,node*2+1));
    }

    static int initMin(int start, int end, int node) {

        if(start==end) return treeMin[node] = arr[start];

        int mid = (start+end)/2;

        return treeMin[node] = Math.min(initMin(start,mid,node*2),initMin(mid+1,end,node*2+1));
    }

    static void find(int start,int end,int node,int left, int right){
        if(left>end||right<start) return;

        if(left <= start && end <= right){
            resultMin = Math.min(resultMin,treeMin[node]);
            resultMax = Math.max(resultMax,treeMax[node]);
            return;
        }

        int mid = (start+end)/2;

        find(start, mid, node * 2, left, right);
        find(mid + 1, end, node * 2 + 1, left, right);
    }

}
