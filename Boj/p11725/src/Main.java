import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for(int i=0; i<N+1; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        parents = new int[N-1];

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(1);

        for(int i : parents){
            System.out.println(i);
        }

    }

    static void dfs(int start){
        visited[start] = true;

        for(int i=0; i<list.get(start).size(); i++){
            if(!visited[list.get(start).get(i)]){
                parents[list.get(start).get(i)-2] = start;
                dfs(list.get(start).get(i));
            }
        }
    }
}