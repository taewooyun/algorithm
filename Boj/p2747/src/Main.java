import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n){
        if(dp[n] > 0) return dp[n];
        if(n == 0) return 0;
        if(n == 1) return 1;

        return dp[n] = fibonacci(n-1) + fibonacci(n-2);
    }
}