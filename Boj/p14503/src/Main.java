import java.io.*;
import java.util.*;

public class Main {
    static int y,x,count;
    static int map[][];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        y = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());
        map = new int[y][x];

        stk = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        count = 1;

        for(int i=0; i<y; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<x; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(r,c,d);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int direction) {
        map[r][c] = -1;

        for(int i=0; i<4; i++) {
            direction = (direction + 3) % 4;
            int ny = r + dy[direction];
            int nx = c + dx[direction];

            if(ny >=0 && ny < y && nx >= 0 && nx < x && map[ny][nx] == 0) {
                count++;
                dfs(ny,nx, direction);

                return;
            }
        }

        int back = (direction + 2) % 4;
        int by = r + dy[back];
        int bx = c + dx[back];

        if(by>=0 && by<y && bx>=0 && bx<x && map[by][bx] != 1) {
            dfs(by,bx,direction);
        }
    }
}