import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int d;

    static int[][] visit;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int cx, cy;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        cy = Integer.parseInt(st.nextToken());
        cx = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visit = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                visit[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(cx, cy, d);
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int direction){
        if(visit[y][x] == 0){
            visit[y][x] = 2;
            cnt++;
        }

        boolean complete = false;
        int enter = direction;

        for(int i=0; i<4; i++){
            int next = (direction + 3) % 4;

            cx = x + dx[next];
            cy = y + dy[next];

            if (inRange()) {
                if(visit[cy][cx] == 0){
                    dfs(cx, cy, next);
                    complete = true;
                    break;
                }
            }

            direction = (direction + 3) % 4;
        }

        if(!complete){
            int back = (enter + 2) % 4;
            cx = x + dx[back];
            cy = y + dy[back];

            if(inRange()){
                if(visit[cy][cx] != 1){
                    dfs(cx, cy, enter);
                }
            }
        }
    }

    static boolean inRange(){
        return 0<=cx&&cx<M&&0<=cy&&cy<N;
    }
}