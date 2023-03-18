import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] a;
    static boolean visit[];	// 정점 탐색여부 체크
    static int n, m, v;		// 정점, 간선, 시작 정점
    static int count = 0;	// 정점과 연결된 바이러스 걸리는 컴퓨터 수

    public static int dfs(int i) {
        visit[i] = true;
        for(int k : a[i]) {
            if(visit[k] == false) {
                count ++;
                dfs(k);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();	// 컴퓨터 수(정점)
        m = scan.nextInt();	// 연결된 컴퓨터 쌍의 수(간선)
        v = 1;	// 탐색 시장할 정점의 번호
        a = new ArrayList[n+1];	// 인덱스 편의상 n+1설정, 0번째 요소는 사용 X
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            int u = scan.nextInt();	// 간선으로 이어진 정점1
            int v = scan.nextInt();	// 정점1과 간선으로 이어진 정점2
            a[u].add(v);
            a[v].add(u);
        }

        System.out.println(dfs(v));

        scan.close();
    }
}