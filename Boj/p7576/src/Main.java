import java.io.*;
import java.util.*;

public class Main {
    static int M, N;

    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cx, cy;

    static int day;
    static Queue<int[]> que;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        que = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int state = Integer.parseInt(st.nextToken());

                if(state > 0){
                    que.offer(new int[] {j, i});
                }
                map[i][j] = state;
            }
        }

        bfs();

        System.out.println(day-1);
    }

    static void bfs(){
        while (!que.isEmpty()){
            int x = que.peek()[0];
            int y = que.poll()[1];

            for(int i=0; i<4; i++){
                cx = x + dx[i];
                cy = y + dy[i];

                if (inRange()) {
                    if(map[cy][cx] == 0){
                        map[cy][cx] = map[y][x] + 1;

                        que.offer(new int[] {cx ,cy});
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    day = 0;
                    return;
                }
                day = Math.max(day, map[i][j]);
            }
        }
    }

    static boolean inRange(){
        return 0<=cx&&cx<M&&0<=cy&&cy<N;
    }
}