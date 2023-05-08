import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;

    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int cx, cy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0,0, K));
    }

    static int bfs(int x, int y, int k){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x, y, k, 0});

        visited[y][x][k] = true;

        while (!que.isEmpty()) {
            x = que.peek()[0];
            y = que.peek()[1];
            k = que.peek()[2];
            int cnt = que.poll()[3];

            if(x == W-1 && y == H-1){
                return cnt;
            }

            if(0 < k){
                for(int i=0; i<8; i++){
                    cx = x + hx[i];
                    cy = y + hy[i];

                    if (inRange()) {
                        if(!visited[cy][cx][k-1] && map[cy][cx] == 0){
                            visited[cy][cx][k-1] = true;
                            que.offer(new int[] {cx, cy, k-1, cnt+1});
                        }
                    }
                }
            }

            for(int i=0; i<4; i++){
                cx = x + dx[i];
                cy = y + dy[i];

                if (inRange()) {
                    if(!visited[cy][cx][k] && map[cy][cx] == 0){
                        visited[cy][cx][k] = true;
                        que.offer(new int[] {cx, cy, k, cnt+1});
                    }
                }
            }
        }

        return -1;
    }

    static boolean inRange(){
        return 0<=cx&&cx<W&&0<=cy&&cy<H;
    }
}