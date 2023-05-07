import java.io.*;
import java.util.*;

public class Main {
    static int R, C;

    static char[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cx, cy;

    static List<Character> route = new ArrayList<>();
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        backtrack(0,0, 0);

        System.out.println(result);
    }

    static void backtrack(int x, int y, int cnt){
        route.add(map[y][x]);
        cnt++;
        result = Math.max(result, cnt);

        for(int i=0; i<4; i++){
            cx = x + dx[i];
            cy = y + dy[i];

            if(!inRange()) continue;
            if(route.contains(map[cy][cx])) continue;

            backtrack(cx, cy, cnt);

            route.remove(route.size()-1);
        }
    }

    static boolean inRange(){
        return 0<=cx&&cx<C&&0<=cy&&cy<R;
    }
}