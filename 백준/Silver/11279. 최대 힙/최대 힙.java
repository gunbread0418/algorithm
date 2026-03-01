import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if(q.isEmpty()) sb.append(0).append("\n");
                else sb.append(q.poll()).append("\n");
            }else {
                q.add(a);
            }
        }
        System.out.println(sb);

    }
}
