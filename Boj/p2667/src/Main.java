import java.io.*;
import java.util.*;
public class Main {
    static int N;

    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int cx, cy;

    static int cnt, size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visit[i][j]){
                    cnt++;
                    size = 0;
                    dfs(j, i);
                    pq.offer(size);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(cnt);
        System.out.print(sb);

    }

    static void dfs(int x, int y){
        visit[y][x] = true;
        size++;

        for(int i=0; i<4; i++){
            cx = x + dx[i];
            cy = y + dy[i];

            if(inRange()){
                if(!visit[cy][cx] && map[cy][cx] == 1){
                    dfs(cx, cy);
                }
            }
        }
    }

    static void bfs(int x, int y){
        visit[y][x] = true;
        size++;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});


        while (!q.isEmpty()){
            x = q.peek()[0];
            y = q.poll()[1];

            for(int i=0; i<4; i++){
                cx = x + dx[i];
                cy = y + dy[i];

                if(inRange()){
                    if (!visit[cy][cx] && map[cy][cx] == 1){
                        q.offer(new int[] {cx, cy});
                        visit[cy][cx] = true;
                        size++;
                    }
                }
            }
        }

    }

    static boolean inRange(){
        return 0 <= cx && cx < N && 0<= cy && cy < N;
    }
}