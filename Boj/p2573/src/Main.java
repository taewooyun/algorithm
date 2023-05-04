import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int[][] nextMap;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        nextMap = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                nextMap[i][j] = map[i][j];
            }
        }

        int year = -1;
        int cnt = 0;

        while (cnt <= 1){
            year++;

            cnt = 0;
            visited = new boolean[N][M];

            for(int i=1; i<N-1; i++){
                for(int j=1; j<M-1; j++){
                    if(!visited[i][j] && map[i][j] > 0){
                        cnt++;
                        dfs(j, i);
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    map[i][j] = nextMap[i][j];
                }
            }

            if(cnt == 0){
                year = 0;
                break;
            }
        }

        System.out.println(year);
    }

    static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(map[cy][cx] == 0){
                if(nextMap[y][x] > 0){
                    nextMap[y][x] -= 1;
                }
            } else if(!visited[cy][cx]){
                dfs(cx, cy);
            }
        }
    }
}