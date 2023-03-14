import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int P[];
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = new int[N];
        for(int i=0; i<N; i++) {
            P[i] = sc.nextInt();
        }
        M = sc.nextInt();
        int ans[] = new int[100];
        int cost = 0;
        int idx = 0;
        int minIdx = findMin(0);
        if(minIdx == 0) {
            minIdx = findMin(1);
            if(P[minIdx] <= M) {
                ans[idx++] = minIdx;
                cost += P[minIdx];
                minIdx = 0;
            }else {
                System.out.println(0);
                return;
            }
        }
        while(cost+P[minIdx] <= M) {
            ans[idx++] = minIdx;
            cost += P[minIdx];
        }

        for(int i=0; i<idx; i++) {
            for(int j=N-1; j>=0; j--) {
                if(cost-P[ans[i]]+P[j] <= M) {
                    cost = cost-P[ans[i]]+P[j];
                    ans[i] = j;
                    break;
                }
            }
        }

        for(int i=0; i<idx; i++) {
            System.out.print(ans[i]);
        }

    }

    public static int findMin(int start) {
        int retIdx=0, min=100;
        for(int i=start; i<N; i++) {
            if(min > P[i]) {
                min = P[i];
                retIdx = i;
            }
        }

        return retIdx;
    }

}