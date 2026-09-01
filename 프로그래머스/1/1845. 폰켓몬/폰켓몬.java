import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int answer = 0;
        int N = nums.length;
        Set<Integer> seen = new HashSet<>();
        
        for(int n : nums) {
            seen.add(n);
        }
        if(seen.size() > N/2) answer = N/2;
        else answer = seen.size();
        

        return answer;
    }
}

// 폰켓몬의 개수는 무조건 짝수 
// 여기서 최대 종류의 폰켓몬을 얻어야 함 

// 일단 번호별로 개수를 구한다
// 하나씩 차감 해서 2/N개가 될 때 까지 구한다. 근데 굳이 그럴 필요가 있나 싶기도 하고 
// 폰켓몬의 종류를 구한다음에 
// 종류의 개수가 2/N 개를 초과 한다면 답은 2/N 일거고 작다면 그 종류의 개수가 답이 아닐까 ? 