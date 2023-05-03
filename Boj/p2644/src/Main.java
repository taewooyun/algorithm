import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int s, e;

    static int[][] map;
    static int[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[n+1][n+1];
        visit = new int[n+1];

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        visit[s] = 1;
        dfs(s);

        if(visit[e] == 0){
            System.out.println(-1);

        } else {
            System.out.println(visit[e]-1);
        }
    }

    static void dfs(int start){
        if(visit[e] > 0) return;

        for(int i=1; i<=n; i++){
            if(visit[i] == 0 && map[start][i] == 1){
                visit[i] = visit[start] + 1;
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            start = q.poll();

            for(int i=1; i<=n; i++){
                if(visit[i] == 0 && map[start][i] == 1){
                    q.offer(i);

                    visit[i] = visit[start] + 1;
                }
            }
        }

    }
}