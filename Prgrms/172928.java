import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] result = new int[2];

        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    result[0] = i;
                    result[1] = j;

                    for(String r : routes){
                        StringTokenizer st = new StringTokenizer(r);
                        int mx, my, dx, dy;
                        mx = my = 0;
                        dx = dy = 1;

                        switch(st.nextToken()){
                            case "N":
                                my = Integer.parseInt(st.nextToken());
                                dy = -1;
                                break;
                            case "S":
                                my = Integer.parseInt(st.nextToken());
                                break;
                            case "W":
                                mx = Integer.parseInt(st.nextToken());
                                dx = -1;
                                break;
                            case "E":
                                mx = Integer.parseInt(st.nextToken());
                                break;
                        }

                        boolean check = true;

                        if(my > 0){
                            for(int k=1; k<=my; k++){
                                if(result[0]+(k*dy) < 0 || park.length <= result[0]+(k*dy) ||
                                        park[result[0]+(k*dy)].charAt(result[1]) == 'X'){
                                    check = false;
                                    break;
                                }
                            }
                            if(check) result[0] += (my*dy);
                        } else {
                            for(int k=1; k<=mx; k++){
                                if(result[1]+(k*dx) < 0 || park[0].length() <= result[1]+(k*dx) ||
                                        park[result[0]].charAt(result[1]+(k*dx)) == 'X'){
                                    check = false;
                                    break;
                                }
                            }
                            if(check) result[1] += (mx*dx);
                        }
                    }
                    return result;
                }
            }

        }
        return result;
    }
}