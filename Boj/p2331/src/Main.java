import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> D = new ArrayList<>();
        D.add(A);

        int result;

        while (true){
            int d = 0;

            while(A != 0) {
                d += Math.pow(A % 10, P);
                A /= 10;
            }

            if(D.contains(d)){
                result = D.indexOf(d);
                break;
            }

            D.add(d);

            A = d;
        }

        System.out.println(result);
    }
}