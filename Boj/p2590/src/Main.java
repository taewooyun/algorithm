import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] papers = new int[7];
        for(int i=1; i<7; i++){
            papers[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        result += papers[6];

        result += papers[5];
        papers[1] -= papers[5] * 11;

        while (papers[4] > 0){
            papers[4]--;
            result++;

            if(papers[2] >= 5){
                papers[2] -= 5;
            } else {
                int empty = 20;
                empty -= papers[2]*4;
                papers[2] = 0;

                papers[1] -= empty;
            }
        }

        while (papers[3] > 0){
            papers[3]--;
            result++;

            if(papers[3] >= 3){
                papers[3] -= 3;
            } else {
                switch (papers[3]){
                    case 0:
                        if(papers[2] >= 5){
                            papers[2] -= 5;
                            papers[1] -= 7;
                        } else {
                            int empty = 27;

                            empty -= papers[2]*4;
                            papers[2] = 0;
                            papers[1] -= empty;
                        }
                        break;
                    case 1:
                        if(papers[2] >= 3){
                            papers[2] -= 3;
                            papers[1] -= 6;
                        } else {
                            int empty = 18;

                            empty -= papers[2]*4;
                            papers[2] = 0;
                            papers[1] -= empty;
                        }
                        break;
                    case 2:
                        if(papers[2] >= 1){
                            papers[2] -= 1;
                            papers[1] -= 5;
                        } else {
                            papers[1] -= 9;
                        }
                        break;
                }
            }
        }

        while (papers[2] > 0){
            papers[2]--;
            result++;

            if(papers[2] >= 8){
                papers[2] -= 8;
            } else {
                int empty = 32;

                empty -= papers[2]*4;
                papers[2] = 0;

                papers[1] -= empty;
            }
        }

        if(papers[1] > 0){
            result += papers[1]/36;
            if(papers[1]%36 > 0){
                result++;
            }
        }

        System.out.println(result);
    }
}