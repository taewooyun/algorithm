import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    static int max = 100001;
    static int[] visit = new int[max];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

        System.out.println(visit[K]-1);
    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        visit[x] = 1;

        while (!q.isEmpty()){
            if(visit[K] > 0) return;

            x = q.poll();

            int forward = x+1;
            int backward = x-1;
            int teleportation = x*2;

            if(forward < max){
                if(visit[forward] == 0){
                    q.offer(forward);
                    visit[forward] = visit[x]+1;
                }
            }

            if(0 <= backward){
                if(visit[backward] == 0){
                    q.offer(backward);
                    visit[backward] = visit[x]+1;
                }
            }

            if(teleportation < max){
                if(visit[teleportation] == 0){
                    q.offer(teleportation);
                    visit[teleportation] = visit[x]+1;
                }
            }
        }
    }
}