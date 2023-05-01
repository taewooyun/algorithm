import java.io.*;
import java.util.*;

public class Main {
    static int height, width;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int cx, cy, count, size;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        visit = new boolean[height][width];

        for(int i = 0; i< height; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<width; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        for(int i = 0; i< height; i++){
            for(int j=0; j<width; j++){
                if(map[i][j] == 1 && !visit[i][j]){
                    count++;
                    size = 0;
                    dfs(j, i);

                    pq.add(size);
                }
            }
        }

        sb.append(count).append("\n").append(pq.peek());

        System.out.println(sb);
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
                    if(!visit[cy][cx] && map[cy][cx] == 1){
                        q.offer(new int[] {cx, cy});
                        visit[cy][cx] = true;

                        size++;
                    }
                }
            }
        }
    }

    static boolean inRange(){
        return (0 <= cy && cy < height && 0 <= cx && cx < width);
    }
}