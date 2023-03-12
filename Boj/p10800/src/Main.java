import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Player implements Comparable<Player>{
        int idx, color, size;

        public Player(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }

        @Override
        public int compareTo(Player o) {
            return this.size - o.size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Player[] players = new Player[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            players[i] = new Player(i, color, size);
        }

        Arrays.sort(players);

        int[] colors = new int[n];
        int[] scores = new int[n];
        int idx = 0;
        int total = 0;

        for(int i=0; i<n; i++){
            Player current = players[i];

            while(players[idx].size < current.size) {
                total += players[idx].size;
                colors[players[idx].color-1] += players[idx].size;
                idx++;
            }
            scores[current.idx] = total - colors[current.color-1];
        }

        for(int i : scores){
            System.out.println(i);
        }
    }
}