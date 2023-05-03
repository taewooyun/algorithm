import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;

    static int[] visit;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visit = new int[F+1];

        bfs(S);

        if(visit[G] > 0){
            System.out.println(visit[G]-1);
        } else {
            System.out.println("use the stairs");
        }


    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visit[start] = 1;

        while (!q.isEmpty()){
            if(visit[G] > 0) return;

            start = q.poll();

            int up = start + U;
            int down = start - D;

            if(up <= F){
                if(visit[up] == 0){
                    q.offer(up);
                    visit[up] = visit[start] + 1;
                }
            }

            if(0 < down){
                if(visit[down] == 0){
                    q.offer(down);
                    visit[down] = visit[start] + 1;
                }
            }
        }
    }
}