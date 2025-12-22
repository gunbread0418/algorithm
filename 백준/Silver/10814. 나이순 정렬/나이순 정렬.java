import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        StringBuffer sb = new StringBuffer();
        Map<Integer,List<String>> map = new TreeMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age =  Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            map.computeIfAbsent(age, k -> new ArrayList<>()).add(name);
        }

        for (Map.Entry<Integer,List<String>> entry :  map.entrySet() ){
            for(String name : entry.getValue()){
                sb.append(entry.getKey()).append(" ").append(name).append("\n");
            }
        }

        System.out.println(sb);
    }
}
