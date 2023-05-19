import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        long mod = 1000000000;

        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            dp[i][0] = dp[i - 1][1] % mod;

            for(int j=1; j<9; j++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % mod;
            }

            dp[i][9] = dp[i - 1][8] % mod;
        }

        long total = 0;

        for(int i=1; i<10; i++){
            total += dp[n][i];
        }

        System.out.println(total % mod);
    }
}