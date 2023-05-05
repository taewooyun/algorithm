import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        int cnt = 0;

        for(int i = 1; i<= N; i++){
            if(!visited[i]){
                cnt++;
                bfs(i);
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);

        visited[start] = true;

        while (!que.isEmpty()) {
            start = que.poll();

            for(int i=1; i<N+1; i++){
                if(!visited[i] && graph[start][i] == 1){
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}