import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());

            Point[] points = new Point[n+2];

            for(int j=0; j<n+2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[j] = new Point(x, y);
            }

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int j=0; j<n+2; j++){
                graph.add(new ArrayList<>());
            }

            for(int j=0; j<n+2; j++){
                for(int k=j+1; k<n+2; k++){
                    if(Math.abs(points[j].x - points[k].x) + Math.abs(points[j].y - points[k].y) <= 1000){
                        graph.get(j).add(k);
                        graph.get(k).add(j);
                    }
                }
            }

            boolean result = bfs(graph, n);

            if(result){
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }

        }

        System.out.print(sb);
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> graph, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visit = new boolean[n+2];
        visit[0] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            if(current == n+1) return true;

            for(int i : graph.get(current)){
                if(!visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }

        return false;
    }
}