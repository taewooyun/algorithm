import java.io.*;
import java.util.*;

public class Main {
    static Queue<String> que;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        que = new LinkedList<>();
        
        dfs(n, "");

        if(k > que.size()) {
            System.out.println(-1);
            return;
        }

        while (k-- > 1){
            que.poll();
        }

        String result = que.peek();

        System.out.println(result.substring(0, result.length()-1));
    }

    static void dfs(int start, String str){
        if(start == 0){
            que.offer(str);
        }

        for(int i=1; i<4; i++){
            int num = start - i;
            if(num >= 0){
                dfs(num, str+i+"+");
            }
        }
    }
}