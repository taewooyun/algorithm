import java.io.*;
import java.util.*;

public class Main {
    static int computer, network;

    static int[][] map;
    static boolean[] visit;
    static int cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        network = Integer.parseInt(br.readLine());

        map = new int[computer+1][computer+1];
        visit = new boolean[computer+1];

        for(int i=0; i<network; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        dfs(1);

        System.out.println(cnt);
    }

    static void dfs(int start){
        visit[start] = true;

        for(int i=1; i<=computer; i++){
            if(!visit[i] && map[start][i] == 1){
                cnt++;
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visit[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();

            for(int i=1; i<=computer; i++){
                if(!visit[i] && map[start][i] == 1){
                    cnt++;
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}