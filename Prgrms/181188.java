import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);
        int answer = 0;
        int temp = 0;
        for(int[] t : targets){
            if(temp <= t[0]){
                temp = t[1];
                answer++;
            }
        }
        return answer;
    }
}