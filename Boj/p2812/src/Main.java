import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String value = br.readLine();

        Deque<Character> dq = new LinkedList<>();

        char[] arr = value.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            while (k > 0 && !dq.isEmpty() && dq.getLast() < arr[i]) {
                dq.removeLast();
                k--;
            }
            dq.addLast(arr[i]);
        }

        while (dq.size() > k){
            System.out.print(dq.pollFirst());
        }
    }
}