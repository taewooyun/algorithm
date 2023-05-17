import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int cx, cy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        dp[N-1][M-1] = map[N-1][M-1];

        bfs(0, 0);

        System.out.println(dp[N-1][M-1]);
    }

    static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x, y});

        while (!que.isEmpty()) {
            x = que.peek()[0];
            y = que.poll()[1];

            for(int i=0; i<2; i++){
                cx = x + dx[i];
                cy = y + dy[i];

                if (inRange()) {
                    if(dp[cy][cx] < dp[y][x] + map[cy][cx]){
                        dp[cy][cx] = dp[y][x] + map[cy][cx];
                        que.offer(new int[] {cx, cy});
                    }
                }
            }
        }
    }

    static boolean inRange(){
        return cx<M&&cy<N;
    }
}