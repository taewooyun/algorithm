class Solution {
    public int solution(int n, int m, int[] section) {
        int roller = 0;
        int result = 0;

        for(int s : section){
            if(roller <= s){
                roller = s+m;
                result++;
            }
        }

        return result;
    }
}