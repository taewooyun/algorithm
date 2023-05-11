import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> colors = new LinkedList<>();
        int N = 0;
        for(int i=0; i<M; i++){
            int color = Integer.parseInt(st.nextToken());
            colors.offer(color);

            N += color;
        }

        int K = Integer.parseInt(br.readLine());

        double a = 0, b = 1;

        while (!colors.isEmpty()) {
            int target = colors.poll();
            if(target<K) continue;

            double temp = 1;

            for(int i=0; i<K; i++){
                temp *= target - i;
            }

            a += temp;
        }

        for(int i=0; i<K; i++){
            b *= N - i;
        }

        System.out.println(a/b);
    }
}