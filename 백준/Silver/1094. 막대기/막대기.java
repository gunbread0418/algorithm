import java.util.*;
import java.io.*;

public class Main {
    static int X;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        int count = 0;
        while(X>0){
            if(X==64){
                X -= 64;
            }else if(X>=32){
                X -= 32;
            }else if(X>=16){
                X -= 16;
            }else if(X>=8){
                X -= 8;
            }else if(X>=4){
                X-= 4;
            }else if(X>=2){
                X -= 2;
            }else {
                X -= 1;
            }
            count ++;
        }
        System.out.println(count);
    }
}
