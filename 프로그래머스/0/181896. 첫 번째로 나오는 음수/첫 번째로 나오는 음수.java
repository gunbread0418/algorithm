class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i : num_list){
            if(i<0) break;
            answer++;
        }
        if(answer==num_list.length) answer = -1;
        return answer;
    }
}