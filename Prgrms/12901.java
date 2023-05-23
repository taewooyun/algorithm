class Solution {
    public String solution(int a, int b) {
        int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int i=0; i<a-1; i++){
            b += dayOfMonth[i];
        }

        switch(b % 7){
            case 1:
                return "FRI";
            case 2:
                return "SAT";
            case 3:
                return "SUN";
            case 4:
                return "MON";
            case 5:
                return "TUE";
            case 6:
                return "WED";
            default :
                return "THU";
        }
    }
}