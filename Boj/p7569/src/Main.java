import java.io.*;
import java.util.*;

public class Main {
    static int zero=0;
    static int cnt=0;
    static int M,N,H;
    static int arr[][][], map[][][];
    static int moveX[] = {0,1,0,-1,0,0};
    static int moveY[] = {-1,0,1,0,0,0};
    static int moveH[] = {0,0,0,0,1,-1};
    static ArrayList<Po> arrList = new ArrayList<>();
    static Queue<Po> tomato = new LinkedList<Po>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[N][M][H];
        map = new int[N][M][H];

        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++) {
                    int val = Integer.parseInt(st.nextToken());
                    if(val == 1) {
                        tomato.add(new Po(m,n,h));
                        arrList.add(new Po(m,n,h));
                    }
                    arr[n][m][h] = val;
                }
            }
        }
        bfs();
        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if(arr[n][m][h]==0)
                        zero++;
                }
            }
        }
        if(cnt==1 && zero>0) {
            System.out.println("0");
        }else if(zero == 0 && cnt>0) {
            System.out.println(cnt-1);
        }else {
            System.out.println("-1");
        }
    }

    public static class Po{
        int x;
        int y;
        int h;
        public Po(int x,int y,int h) {
            this.x=x;
            this.y=y;
            this.h=h;
        }
    }

    public static void bfs() {
        Queue<Po> queue = new LinkedList<>();
        for(int i=0; i<arrList.size(); i++) {
            Po p = arrList.get(i);
            map[p.y][p.x][p.h] = 1;
            queue.add(new Po(p.x, p.y, p.h));
        }
        while(!queue.isEmpty()) {
            int current = tomato.size();
            for(int i=0; i<current; i++) {
                Po p = tomato.poll();
                int currentX = p.x;
                int currentY = p.y;
                int currentH = p.h;

                for(int d=0; d<6; d++) {
                    int newX = currentX + moveX[d];
                    int newY = currentY + moveY[d];
                    int newH = currentH + moveH[d];


                    if(0<=newX && newX<M && 0<=newY && newY<N && 0<=newH && newH<H) {
                        if(arr[newY][newX][newH] == 0) {
                            arr[newY][newX][newH] = 1;
                            tomato.add(new Po(newX, newY, newH));
                        }
                    }
                }

            }
            current = queue.size();
            for(int i=0; i<current; i++) {
                Po p = queue.poll();
                int x = p.x;
                int y = p.y;
                int h = p.h;

                for(int d=0; d<6; d++) {
                    int newX = x + moveX[d];
                    int newY = y + moveY[d];
                    int newH = h + moveH[d];
                    if(0<=newX && newX<M && 0<=newY && newY<N && 0<=newH && newH<H) {
                        if(arr[newY][newX][newH]==1 && arr[newY][newX][newH]!=-1 && map[newY][newX][newH]==0) {
                            map[newY][newX][newH] = map[y][x][h] + 1;
                            queue.add(new Po(newX,newY,newH));
                        }
                    }
                }
            }
            cnt++;
        }
    }
}