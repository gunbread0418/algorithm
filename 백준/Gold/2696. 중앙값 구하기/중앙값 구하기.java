import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
            int count = 0;
            if(N%2==1) count = N/2+1;
            else count = N/2;
            sb.append(count).append("\n");

            int printCount = 0;

            for (int j = 1; j <= N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (pq2.size() == pq1.size()) {
                    pq2.add(a);
                } else {
                    pq1.add(a);
                }
                if (!pq1.isEmpty() && !pq2.isEmpty() && pq2.peek() > pq1.peek()) {
                    int temp = pq1.poll();
                    int temp2 = pq2.poll();
                    pq2.add(temp);
                    pq1.add(temp2);
                }

                if (j % 2 == 1) {
                    sb.append(pq2.peek()).append(" ");
                    printCount++;

                    if (printCount % 10 == 0) {
                        sb.append("\n");
                    }
                }

                if(j%10==0&&j<N) st = new StringTokenizer(br.readLine());
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
