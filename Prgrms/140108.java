import java.util.*;

class Solution {
    public int solution(String s) {
        Queue<Character> que = new LinkedList<>();
        for(char c : s.toCharArray()){
            que.offer(c);
        }
        int answer = 1;

        char x = que.poll();
        int same = 1;
        int diff = 0;

        while(!que.isEmpty()){
            if(same == -1){
                x = que.poll();
                same = 1;
                diff = 0;
                answer++;
                continue;
            }

            char current = que.poll();
            if(x == current){
                same++;
            } else {
                diff++;
            }
            if(same == diff){
                same = -1;
            }
        }
        return answer;
    }
}