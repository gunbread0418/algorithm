import java.io.*;
import java.util.*;

/**
 * 앞에서 탐색
 * 뒤에서 탐색
 * 근데 여기서 다 탐색할 필요는 없고 홀수면 뭐 중앙은 어디서 탐색하는지 상관 x
 * 짝수면 앞에서 반 뒤에서 반
 *
 * 처음에 순서를 고려안해도 생각했지만 그게 아니었다
 * 찾고나면 위치가 바뀌기 때문에 그거까지 고려해줘야 하니깐 순서를 고려 해줘야 함
 */

public class Main {
    static int h;
    static int l;
    static int[] matrix;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            matrix = new int[l+1];
            int sum = 0; // 중간 결과
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < l; j++) { // 한칸마다 5초 이동
                    int a = Integer.parseInt(st.nextToken());
                    matrix[j] = a;
                    if(a!=-1) pq.add(a); // 검사할 리스트

                }

                int start = 0 ; // 시작 위치

                while(!pq.isEmpty()){
                    int val = pq.poll(); // 찾아야할 값
                    int[] info1 = left(start,val);
                    int[] info2 = right(start,val);
                    if(info1[1]<info2[1]){
                        sum += info1[1]*5 + i*10*2;
                        start = info1[0];
                    }else{
                        sum += info2[1]*5 + i*10*2;
                        start = info2[0];
                    }
                }
            }

            sb.append(sum).append("\n");

        }
        System.out.println(sb);
    }
    static int[] left(int start, int val){
        int count = 0;
        int[] info = new int[2];
        while(true){
            start--;
            count++;
            if(start < 0) start = l - 1;
            if(matrix[start] == val) {
                info[0] = start;
                info[1] = count;
                return info;
            }
        }
    }
    static int[] right(int start, int val){
        int count = 0;
        int[] info = new int[2];
        while (true) {
            start++;
            count++;
            if(start >= l) start = 0;
            if(matrix[start] == val) {
                info[0] = start;
                info[1] = count;
                return info;
            }
        }
    }




}
