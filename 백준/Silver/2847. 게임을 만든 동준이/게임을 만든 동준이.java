import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int prev = arr[N-1];
        for(int i = N-2;i>=0;i--){
            if(prev<=arr[i]){
                int a  = arr[i] - prev + 1;
                count += a;
                arr[i] -= a;
            }
            prev = arr[i];
        }

        System.out.println(count);
    }
}
