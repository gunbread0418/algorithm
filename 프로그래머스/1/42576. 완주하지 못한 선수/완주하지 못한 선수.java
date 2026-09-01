import java.util.*;

class Solution {
    static Map<String, Integer> cList = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        for(String name : completion){
            if(cList.containsKey(name)){
                int a = cList.get(name);
                cList.put(name,a+1);
            }else cList.put(name,1);
        } // 여기까지 넣는거 끝
        
        // 이제 검색 로직 시작
        for(String name : participant){
            if(cList.containsKey(name)){
                int a = cList.get(name);
                if(a-1 == 0) cList.remove(name);
                else cList.put(name,a-1);
            } else {
                answer = name;
                break;
            }
        }
        return answer;
    }
}

// completion을 map에 다 넣고 그 결과 participant 랑 비교한다.