import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sb = new StringBuilder();

        permutation(0, 0, "");

        System.out.print(sb);
    }

    static void permutation(int start, int cnt, String str){
        if(cnt == M){
            sb.append(str).append("\n");
            return;
        }

        for(int i=start; i<N; i++){
            permutation(i, cnt+1, str+arr[i]+" ");
        }
    }
}