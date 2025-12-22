import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("all")){
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
            }else if(cmd.equals("empty")){
                set.clear();
            }else {
                int val = Integer.parseInt(st.nextToken());
                if(cmd.equals("add")){
                    set.add(val);
                }else if(cmd.equals("check")){
                    if(set.contains(val)) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }else if(cmd.equals("remove")){
                    set.remove(val);
                }else{
                    if(set.contains(val)) set.remove(val);
                    else set.add(val);
                }
            }
        }
        System.out.print(sb);
    }
}
