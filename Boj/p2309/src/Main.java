import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> member = new ArrayList<>();
        int sum = 0;

        for(int i=0; i<9;i++){
            int m = Integer.parseInt(br.readLine());
            sum += m;
            member.add(m);
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(j==i) continue;

                if(sum - member.get(i) - member.get(j) == 100){
                    if(i < j){
                        member.remove(j);
                        member.remove(i);
                    } else {
                        member.remove(i);
                        member.remove(j);
                    }

                    Collections.sort(member);

                    for(int k=0; k<7; k++){
                        System.out.println(member.get(k));
                    }

                    return;
                }
            }
        }
    }
}