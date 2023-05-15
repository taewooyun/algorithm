import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N][20+1];

        dp[0][arr[0]]=1;

        int p, m;

        for(int i=1; i<N-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j] != 0){
                    p = j+arr[i];
                    m = j-arr[i];
                    if(0 <= p && p <= 20){
                        dp[i][p] += dp[i-1][j];
                    }
                    if(0 <= m && m <= 20){
                        dp[i][m] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[N-2][arr[N-1]]);
    }
}