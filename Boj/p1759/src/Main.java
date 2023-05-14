import java.io.*;
import java.util.*;


public class Main {
    static int L, C;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[C];
        visited = new boolean[27];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
           arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        sb = new StringBuilder();
        permutation(0, 0, 0, "");
        System.out.print(sb);
    }

    static void permutation(int start, int cCnt, int vCnt, String str){
        if(cCnt+vCnt == L) {
            if(2<=cCnt && 1<=vCnt){
                sb.append(str).append("\n");
            }
            return;
        }

        int nextC = cCnt;
        int nextV = vCnt;

        for(int i=start; i<C; i++){
            int c = arr[i]-'`';

            if (!visited[c]) {
                switch (c+'`'){
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        nextV++;
                        break;
                    default:
                        nextC++;
                }

                visited[c] = true;
                permutation(i, nextC, nextV, str + (char)(c+'`'));

                nextC = cCnt;
                nextV = vCnt;
                visited[c] = false;
            }
        }
    }
}