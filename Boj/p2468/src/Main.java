import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cx, cy;
    static int amount;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                int height = Integer.parseInt(st.nextToken());
                pq.offer(height);

                map[i][j] = height;
            }
        }

        int maxAmount = pq.peek();
        pq.clear();
        pq.offer(1);

        for(int i=1; i<maxAmount; i++){
            visit = new boolean[N][N];
            int safeArea = 0;
            amount = i;

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(map[j][k] > amount && !visit[j][k]){
                        safeArea++;
                        dfs(k, j);
                    }
                }
            }

            pq.offer(safeArea);
        }

        System.out.println(pq.peek());
    }

    static void dfs(int x, int y){
        visit[y][x] = true;

        for(int i=0; i<4; i++){
            cx = x + dx[i];
            cy = y + dy[i];

            if(inRange()){
                if(!visit[cy][cx] && map[cy][cx] > amount){
                    visit[cy][cx] = true;
                    dfs(cx, cy);
                }
            }
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        visit[y][x] = true;

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.poll()[1];

            for(int i=0; i<4; i++){
                cx = x + dx[i];
                cy = y + dy[i];

                if(inRange()){
                    if(!visit[cy][cx] && map[cy][cx] > amount){
                        q.offer(new int[] {cx, cy});

                        visit[cy][cx] = true;
                    }
                }
            }
        }
    }

    static boolean inRange(){
        return 0 <= cx && cx < N && 0 <= cy && cy < N;
    }
}