class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(char word : s.toCharArray()){
            for(int j=0; j<index; j++){
                word++;
                if('z' < word) word -= 26;
                if(skip.contains(String.valueOf(word))){
                    j--;
                }
            }
            answer += Character.toString(word);
        }
        return answer;
    }
}