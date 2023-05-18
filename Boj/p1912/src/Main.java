import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
        }

        int max = -100001;
        for(int i : dp){
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}