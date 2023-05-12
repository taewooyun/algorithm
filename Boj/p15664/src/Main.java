import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Integer[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        visited = new boolean[arr.length];

        sb = new StringBuilder();

        set = new HashSet<>();

        permutation(0, 0, "");

        System.out.print(sb);
    }

    static void permutation(int start, int cnt, String str){
        if(cnt == M){
            if(!set.contains(str)){
                sb.append(str).append("\n");
                set.add(str);
            }

            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(i, cnt+1, str+arr[i]+" ");
                visited[i] = false;
            }
        }
    }
}