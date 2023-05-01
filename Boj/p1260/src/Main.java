import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[][] map;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        visit = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visit = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int start){
        visit[start] = true;
        sb.append(start).append(" ");

        for(int i=0; i<= N; i++){
            if(!visit[i] && map[start][i] == 1)
                dfs(i);
        }

    }

    static void bfs(int start){
        visit[start] = true;

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()){
            start = q.poll();
            sb.append(start).append(" ");

            for(int i=0; i <= N; i++){
                if(!visit[i] && map[start][i] == 1){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }

    }
}