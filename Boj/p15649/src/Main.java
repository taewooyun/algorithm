import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Queue<String> que;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        que = new LinkedList<>();
        visited = new boolean[N+1];

        permutation(0, "");

        while (!que.isEmpty()) {
            System.out.println(que.poll());
        }
    }

    static void permutation(int cnt, String str){
        if(cnt == M){
            que.offer(str);
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(cnt+1, str+i+" ");
                visited[i] = false;
            }
        }
    }
}