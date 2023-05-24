import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<yearning.length; i++){
            map.put(name[i], i);
        }

        for(int i=0; i<photo.length; i++){
            for(String p : photo[i]){
                if(!map.containsKey(p)) continue;
                int idx = map.get(p);
                result[i] += yearning[idx];
            }
        }

        return result;
    }
}