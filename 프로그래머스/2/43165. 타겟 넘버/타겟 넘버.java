class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0,numbers, target,0);
        return answer;
    }
    
    void dfs(int result,int[] numbers, int target, int idx){
        if(idx==numbers.length) {
            if(result==target) answer++;
            return;
        }
        dfs(result+numbers[idx],numbers,target,idx+1);
        dfs(result-numbers[idx],numbers,target,idx+1);
        
    }
    
}


// 다 해보는 방법인데 가지칠 수 있으면 가지치기 ? 의미있나 ? 가지치기도 내가 어떤게 가지칠 수 있는 경우인지 알아야 함 
// 심지어 numbers에 있는 숫자들이 다 1이 아니라 무작위 임 
// 미리 계산 결과를 보내서 시간 줄이기 ? 
// 하나씩 + - 다 시도 
// 처음에 +를 시도 했다면 그상태에서 다음 자리 + - 다 시도를 한다 . 
// 그리고 그 전 상태로 돌아 올줄 알아야 한다 
