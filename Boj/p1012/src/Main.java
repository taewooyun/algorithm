import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int[][] map;
    static boolean[][] visit;

    static int cx, cy;
    static int M, N, K;
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];

            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            count = 0;

            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[j][k] == 1 && !visit[j][k]){
                        count++;
                        bfs(k, j);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y){
        visit[y][x] = true;

        for(int i=0; i<4; i++){
            cx = x+dx[i];
            cy = y+dy[i];

            if(inRange()){
                if(!visit[cy][cx] && map[cy][cx] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }

    static void bfs(int x, int y){
        visit[y][x] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while (!q.isEmpty()){
            x = q.peek()[0];
            y = q.poll()[1];

            for(int i=0; i<4; i++){
                cx = x + dx[i];
                cy = y + dy[i];

                if(inRange()){
                    if(!visit[cy][cx] && map[cy][cx] == 1){
                        q.offer(new int[] {cx, cy});
                        visit[cy][cx] = true;
                    }
                }
            }

        }

    }


    static boolean inRange() {
        return (cy < N && cy >= 0 && cx < M && cx >= 0);
    }
}