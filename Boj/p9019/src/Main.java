import java.io.*;
import java.util.*;

public class Main {
    static int A, B;

    static String[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            visited = new String[10000];

            bfs();

            sb.append(visited[B]).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.offer(A);

        visited[A] = "";

        while (!que.isEmpty() && visited[B] == null) {
            int current = que.poll();

            int d = (2 * current) % 10000;
            int s = current == 0 ? 9999 : current - 1;
            int l = (current % 1000) * 10 + current / 1000;
            int r = (current % 10) * 1000 + current / 10;

            if(visited[d] == null){
                visited[d] = visited[current]+"D";
                que.offer(d);
            }

            if(visited[s] == null){
                visited[s] = visited[current]+"S";
                que.offer(s);
            }

            if(visited[l] == null){
                visited[l] = visited[current]+"L";
                que.offer(l);
            }

            if(visited[r] == null){
                visited[r] = visited[current]+"R";
                que.offer(r);
            }
        }
    }
}