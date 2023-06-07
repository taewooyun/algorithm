class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length-1};
        int start = 0;
        int end = 0;
        int sum = sequence[end];

        while(start <= sequence.length-1){
            if(sum == k && answer[1]-answer[0] > end-start){
                answer[0] = start;
                answer[1] = end;
            }

            if(k < sum || end == sequence.length-1){
                sum -= sequence[start++];
            } else {
                sum += sequence[++end];
            }
        }

        return answer;
    }
}