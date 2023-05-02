import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cx, cy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();

            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(map[N-1][M-1]);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {x, y});
        visit[y][x] = true;

        while (!q.isEmpty()){
            x = q.peek()[0];
            y = q.poll()[1];

            for(int i=0; i<4; i++){
                cx = x+dx[i];
                cy = y+dy[i];

                if(inRange()){
                    if(!visit[cy][cx] && map[cy][cx] == 1){
                        q.offer(new int[] {cx, cy});
                        visit[y][x] = true;

                        map[cy][cx] = map[y][x]+1;

                        if(visit[N-1][M-1]){
                            return;
                        }
                    }
                }
            }
        }

        visit[y][x] = true;
    }

    static boolean inRange(){
        return 0 <= cx && cx < M && 0 <= cy && cy < N;
    }
}