import java.io.*;
import java.util.*;

public class Main {
    static int T, l;

    static int[][] visit;

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    static int cx, cy;
    static int gx, gy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            l = Integer.parseInt(br.readLine());
            visit = new int[l][l];

            StringTokenizer st;

            st = new StringTokenizer(br.readLine());

            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            gx = Integer.parseInt(st.nextToken());
            gy = Integer.parseInt(st.nextToken());

            bfs(cx, cy);

            sb.append(visit[gy][gx]-1).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        visit[y][x] = 1;

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.poll()[1];

            for(int i=0; i<8; i++){
                if(visit[gy][gx] > 0) return;

                cx = x + dx[i];
                cy = y + dy[i];

                if (inRange()) {
                    if (visit[cy][cx] == 0){
                        q.offer(new int[] {cx, cy});
                        visit[cy][cx] = visit[y][x] + 1;
                    }
                }
            }
        }
    }

    static boolean inRange(){
        return 0 <= cx && cx < l && 0 <= cy && cy < l;
    }
}