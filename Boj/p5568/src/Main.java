import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] cards;
    static boolean[] visited;
    static Set<String> numbers;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new int[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(br.readLine());
        }

        numbers = new HashSet<>();

        permutation(0, "");

        System.out.println(numbers.size());
    }

    static void permutation(int selected, String str){
        if(selected == k) {
            numbers.add(str);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(selected+1, str + cards[i]);
                visited[i] = false;
            }
        }
    }
}