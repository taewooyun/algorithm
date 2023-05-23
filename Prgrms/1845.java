import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int limit = nums.length/2;

        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        if(limit < set.size()){
            return limit;
        } else {
            return set.size();
        }
    }
}