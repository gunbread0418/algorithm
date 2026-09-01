import java.util.*;
import java.io.*;



class Solution {
    
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static boolean isVisited[]; 
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        
        for ( int i = 0 ; i < n ; i++ ) {
            for( int j = 0; j < n ; j++ ) {
                if(computers[i][j]==1 && isVisited[i]==false){
                    isVisited[i] = true;
                    q.add(i);
                    bfs(computers,n);
                    //System.out.println("i: "+i+" j: "+j+"에서 돌았음");
                    answer ++;
                }
            }
        }
        
        return answer;
    }
    
    void bfs(int computers[][] , int n){
        while(!q.isEmpty()){
            int target = q.pop();
            for(int j = 0 ; j < n ; j++) { 
                if(computers[target][j] == 1 && isVisited[j] == false) {                            // System.out.println("bfs target: "+target+" j: "+j+"에서 돌았음");
                    q.add(j);
                    isVisited[j] = true;
                }
            
            }
            
            
            
        }
        
        
    }
}


// 섬의 개수 구하는 문제랑 비슷하다 ? 동일하다 ? 고 보면 된다 .
// 노드들을 queue 에 넣고 
// 연결이 되는거 방문처리 if 1 에서 1 ,1 ,1 이렇게면 자신과 같은 노드는 pass  하고 
// 처음에 1에 연결된 노드 큐에 다 넣고 방문한다 이제 만약 2가 됐다면 2를 넣고 또 2에 연결된 노드 방문 처리 
// 방문한 노드 처리는 ? 
// visited도 하나만 만들어도 되겠다  point class도 굳이 만들 필요 없겠다 .




