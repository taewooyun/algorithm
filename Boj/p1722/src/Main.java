import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        long[] fac = new long[N];

        for(int i=1; i<=N; i++){
            arr.add(i);
        }
        fac[0] = 1;
        for(int i=1; i<N; i++){
            fac[i] = i*fac[i-1];
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());

        if(p == 1){
            long target = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for(int i=1; i<=N; i++){
                int idx = 1;
                while (idx*fac[N-i] < target){
                    idx++;
                }
                sb.append(arr.get(idx-1)).append(" ");
                arr.remove(idx-1);

                target -= fac[N-i]*(idx-1);
            }

            System.out.println(sb);
        } else {
            List<Integer> target = new ArrayList<>();
            for(int i=0; i<N; i++){
                target.add(Integer.parseInt(st.nextToken()));
            }

            long result = 0;
            for(int i=0; i<N; i++){
                int idx = arr.indexOf(target.get(i));

                result += fac[N-(i+1)]*(idx);

                arr.remove(idx);
            }

            System.out.println(result+1);
        }
    }
}