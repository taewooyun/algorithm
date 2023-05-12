import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        permutation(0, "");

        System.out.print(sb);
    }

    static void permutation(int cnt, String str){
        if(cnt == M){
            sb.append(str).append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            permutation(cnt+1, str+i+" ");
        }
    }
}