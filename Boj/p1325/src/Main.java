import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] result;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[B].add(A);
        }

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];

            bfs(i);
        }

        max = 0;
        for(int i=1; i<N+1; i++){
            max = Math.max(max, result[i]);
        }
        for(int i=1; i<N+1; i++){
            if(result[i] == max){
                System.out.print(i+" ");
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);

        visited[start] = true;

        while (!que.isEmpty()) {
            int current = que.poll();
            for(int i : graph[current]){
                if(!visited[i]){
                    result[start]++;
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}