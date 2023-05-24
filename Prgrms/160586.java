class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];

        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                int min = 101;
                for(int k=0; k<keymap.length; k++){
                    int click = 0;
                    for(int l=0; l<keymap[k].length(); l++){
                        click++;
                        if(targets[i].charAt(j) == keymap[k].charAt(l)){
                            min = Math.min(min, click);
                        }
                    }
                }
                if(min == 101){
                    result[i] = -1;
                    break;
                }
                result[i] += min;
            }
        }

        return result;
    }
}