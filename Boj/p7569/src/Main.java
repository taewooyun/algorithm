import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] visit;

    static int[] dx = {1, 0, 0, -1, 0, 0};
    static int[] dy = {0, 1, 0, 0, -1, 0};
    static int[] dz = {0, 0, 1, 0, 0, -1};
    static int cx, cy, cz;

    static int day;

    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visit = new int[H][N][M];

        q = new LinkedList<>();

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    int state = Integer.parseInt(st.nextToken());

                    if(state > 0){
                        q.offer(new int[] {k, j, i});
                    }

                    visit[i][j][k] = state;
                }
            }
        }

        day = 0;

        bfs();

        System.out.println(day-1);
    }

    static void bfs(){
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int z = q.poll()[2];

            for(int i=0; i<6; i++){
                cx = x + dx[i];
                cy = y + dy[i];
                cz = z + dz[i];

                if(inRange()){
                    if(visit[cz][cy][cx] == 0){
                        visit[cz][cy][cx] = visit[z][y][x] + 1;

                        q.offer(new int[] {cx, cy, cz});
                    }
                }
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(visit[i][j][k] == 0){
                        day = 0;
                        return;
                    }

                    day = Math.max(day, visit[i][j][k]);
                }
            }
        }
    }


    static boolean inRange(){
        return 0 <= cx && cx < M && 0 <= cy & cy < N && 0 <= cz && cz < H;
    }
}