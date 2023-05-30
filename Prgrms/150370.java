import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<privacies.length; i++){
            String[] pInfo = privacies[i].split(" ");
            for(String t : terms){
                String[] tInfo = t.split(" ");

                if(pInfo[1].equals(tInfo[0])){
                    if(getRaw(today) - getRaw(pInfo[0]) >= Integer.parseInt(tInfo[1])*28){
                        answer.add(i+1);
                    }
                    break;
                }
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    static int getRaw(String s){
        int raw = 0;

        String[] date = s.split("\\.");
        int y = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int d = Integer.parseInt(date[2]);

        raw += (y-1) * 12 * 28;
        raw += (m-1) * 28;
        raw += d;

        return raw;
    }
}