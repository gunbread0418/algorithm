import java.util.*;
import java.io.*;

class Solution {
    public int solution(String my_string, String target) {
        int answer = 0;
        
        for(int i = 0 ; i < my_string.length(); i++) { // my_string 의 기준점
            for(int j = 0 ; j < target.length(); j++) { // target의 기준점
                if(i+j<my_string.length()&&my_string.charAt(i+j)==target.charAt(j)){
                    if(j+1==target.length()) answer = 1;
                }else break;
            }
        }
        
        return answer;
    }
}