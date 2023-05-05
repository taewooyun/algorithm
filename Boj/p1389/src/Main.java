import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                graph[i][j] = i == j ? 0 : MAX;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N; k++){
                    if(graph[j][k] > graph[j][i] + graph[i][k]){
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        int min = MAX;
        int idx = -1;

        for(int i=1; i<=N; i++){
            int kb = 0;
            for(int j=1; j<=N; j++){
                kb += graph[i][j];
            }

            if(kb < min){
                idx = i;
                min = kb;
            }
        }

        System.out.println(idx);
    }
}