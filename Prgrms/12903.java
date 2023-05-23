class Solution {
    public String solution(String s) {
        return s.length() % 2 == 0 ?
                Character.toString(s.charAt(s.length()/2-1))+Character.toString(s.charAt(s.length()/2)) : Character.toString(s.charAt(s.length()/2));
    }
}