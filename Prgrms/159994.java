import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>();
        Queue<String> que2 = new LinkedList<>();

        for(String s : cards1){
            que1.offer(s);
        }
        for(String s : cards2){
            que2.offer(s);
        }

        for(String s : goal){
            if(!que1.isEmpty() && que1.peek().equals(s)){
                que1.poll();
            } else if(!que2.isEmpty() && que2.peek().equals(s)){
                que2.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}