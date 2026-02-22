import java.util.*;
import java.io.*;

class Num implements Comparable<Num>{
    int real;
    int val;

    Num(int real, int val){
        this.real = real;
        this.val = val;
    }

    @Override
    public int compareTo(Num o) {
        if(this.val==o.val) return this.real-o.real;
        return this.val-o.val;
    }
}

public class Main {
    static PriorityQueue<Num> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                if(!pq.isEmpty()) sb.append(pq.poll().real);
                else sb.append(0);

                sb.append("\n");
            }
            else{
                pq.add(new Num(a,Math.abs(a)));
            }
        }
        System.out.println(sb);
    }
}
