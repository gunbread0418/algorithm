import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wmax = Integer.MIN_VALUE;
        int hmax = Integer.MIN_VALUE;
        for(int i =0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){
                wmax = Math.max(wmax,sizes[i][1]);
                hmax = Math.max(hmax,sizes[i][0]);
            }else {
                wmax = Math.max(wmax,sizes[i][0]);
                hmax = Math.max(hmax,sizes[i][1]);
            }
        }
        answer = wmax * hmax;
        return answer;
    }
}

// 일단 제일 큰 길이는 확정 그 중에서 
// 가로와 세로 길이를 어떻게 정하냐 관건 
// 일단 가로와 세로 중에 제일 큰거를 가로로 다 보낸 다음에 그중에 세로에서 최댓값을 찾는다 ? 
// 1. 가로 세로 비교 후 재 정렬 그리고 가로와 세로의 최댓값 각각 갱신 