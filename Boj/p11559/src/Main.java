import java.io.*;
import java.util.*;

public class Main {
    static int X = 6;
    static int Y = 12;

    static int[][] map = new int[Y][X];
    static boolean[][] visited = new boolean[Y][X];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cx, cy;

    static Queue<int[]> chainQue;
    static boolean finished;
    static int chain;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<Y; i++){
            String s = br.readLine();
            for(int j=0; j<X; j++){
                switch (s.charAt(j)){
                    case 'R':
                        map[i][j] = 1;
                        break;
                    case 'G':
                        map[i][j] = 2;
                        break;
                    case 'B':
                        map[i][j] = 3;
                        break;
                    case 'P':
                        map[i][j] = 4;
                        break;
                    case 'Y':
                        map[i][j] = 5;
                        break;
                    default:
                        map[i][j] = 0;
                }
            }
        }

        while (true){
            visited = new boolean[Y][X];
            finished = true;

            for(int i=0; i<Y; i++){
                for(int j=0; j<X; j++){
                    if(map[i][j] != 0 && !visited[i][j]){
                        chainQue = new LinkedList<>();
                        bfs(j, i);

                        if(4 <= chainQue.size()){
                            while (!chainQue.isEmpty()) {
                                int x = chainQue.peek()[0];
                                int y = chainQue.poll()[1];
                                map[y][x] = 0;
                            }

                            finished = false;
                        }
                    }
                }
            }

            if(finished) break;
            chain++;
            gravity();
        }

        System.out.println(chain);
    }

    static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x, y});

        chainQue.offer(new int[] {x, y});

        visited[y][x] = true;

        while (!que.isEmpty()) {
            x = que.peek()[0];
            y = que.poll()[1];

            for(int i=0; i<4; i++){
                cx = x + dx[i];
                cy = y + dy[i];

                if (inRange()) {
                    if(!visited[cy][cx] && map[cy][cx] == map[y][x]){
                        que.offer(new int[] {cx, cy});
                        chainQue.offer(new int[] {cx, cy});

                        visited[cy][cx] = true;
                    }
                }
            }
        }
    }

    static boolean inRange(){
        return 0<=cx&&cx<X&&0<=cy&&cy<Y;
    }

    static void gravity(){
        for(int i=0; i<X; i++){
            for(int j=Y-1; 0<j; j--){
                if(map[j][i] == 0){
                    for(int k=j-1; 0<=k; k--){
                        if(map[k][i] != 0){
                            map[j][i] = map[k][i];
                            map[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
}