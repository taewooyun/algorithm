import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int[][] graph;
    static boolean[] visited;
    static int visitCnt;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        visitCnt = 1;
        backtrack(0, 0, 0);

        System.out.println(min);

    }

    static void backtrack(int start, int current, int cost){
        if(N == visitCnt && graph[current][start] != 0){
            min = Math.min(min, cost + graph[current][start]);
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i] || graph[current][i] == 0) continue;
            if(min <= cost + graph[current][i]) continue;

            visited[i] = true;
            visitCnt++;

            backtrack(start, i, cost+graph[current][i]);

            visited[i] = false;
            visitCnt--;
        }
    }
}