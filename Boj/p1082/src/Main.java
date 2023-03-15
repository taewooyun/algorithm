import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Number implements Comparable<Number>{
        int number, cost;
        public Number(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Number o) {
            if(this.cost > o.cost){
                return 1;
            } else if (this.cost == o.cost) {
                return o.number - this.number;
            } else {
                return -1;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        PriorityQueue<Number> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(new Number(i, p[i]));
        }

        Number first = pq.poll();
        Number second = pq.poll();

        List<Number> result = new ArrayList<>();

        if(n>1){
            if(first.number == 0 && m >= second.cost){
                result.add(second);
                m -= second.cost;
            }
        }
        while (m >= first.cost){
            result.add(first);
            m -= first.cost;
        }

        for(int i=0; i<result.size(); i++){
            Number target = result.get(i);

            for(int j=n-1; j>-1; j--){
                if(m >= p[j]-target.cost){
                    m -= p[j]-target.cost;
                    result.set(i, new Number(j,p[j]));

                    break;
                }
            }
        }

        String answer = "";
        for(Number i : result){
            answer += i.number;
        }

        if(answer.charAt(0) == '0'){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}