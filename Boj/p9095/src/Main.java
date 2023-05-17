import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[10+1];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i=4; i<=n; i++){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}