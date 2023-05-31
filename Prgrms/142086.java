class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        answer[0] = -1;
        for(int i=1; i<s.length(); i++){
            answer[i] = -1;
            for(int j=1; j<=i; j++){
                if(s.charAt(i) == s.charAt(i-j)){
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
}