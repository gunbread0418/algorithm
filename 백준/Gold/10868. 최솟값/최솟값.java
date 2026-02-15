import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tree = new int[N * 4];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(0, N - 1, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(find(0, N - 1, 1, a - 1, b - 1)).append("\n");

        }
        System.out.println(sb);
    }

    static int init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }

    static int find(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return Integer.MAX_VALUE;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        return Math.min(find(start, mid, node * 2, left, right), find(mid + 1, end, node*2+1, left, right));
    }

}
