import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int map[][];
    static boolean visit[][];

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int cx, cy;
    static int cnt, size;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for(int j=startY; j<endY; j++){
                for(int k=startX; k<endX; k++){
                    map[j][k] = 1;
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] && map[i][j] == 0){
                    cnt++;
                    size = 0;
                    dfs(j, i);
                    pq.add(size);
                }
            }
        }

        StringBuilder sb =  new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    static void dfs(int x, int y){
        visit[y][x] = true;
        size++;

        for(int i=0; i<4; i++){
            cx = x + dx[i];
            cy = y + dy[i];

            if (inRange()) {
                if(!visit[cy][cx] && map[cy][cx] == 0){
                    dfs(cx, cy);
                }
            }
        }
    }

    static void bfs(int x, int y){
        visit[y][x] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.poll()[1];
            size++;

            for(int i=0; i<4; i++){
                cx = x + dx[i];
                cy = y + dy[i];

                if (inRange()) {
                    if(!visit[cy][cx] && map[cy][cx] == 0){
                        q.offer(new int[] {cx, cy});
                        visit[cy][cx] = true;
                    }
                }
            }
        }

    }

    static boolean inRange(){
        return 0 <= cx && cx < N && 0 <= cy && cy < M;
    }
}