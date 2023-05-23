import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(arr[0]);
        for(int i : arr){
            if(dq.peekLast() != i){
                dq.offerLast(i);
            }
        }

        return dq.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}