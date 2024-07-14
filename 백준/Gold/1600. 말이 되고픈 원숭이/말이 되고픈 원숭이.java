import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int r;
    int c;
    int kCnt;
    int move;

    public Node(int r, int c, int kCnt, int move){
        this.r = r;
        this.c = c;
        this.kCnt = kCnt;
        this.move = move;
    }
}



public class Main {
    static int[] dr = {-1, 1, 0,0};
    static int[] dc = {0, 0, -1, 1};
    static int[] hdr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdc = {-1, 1, -2, 2, -2, 2, -1, 1};
//    static List<Obstacle> obList = new ArrayList<>();
    static int minMove= Integer.MAX_VALUE;
    static int K, C, R;
    static int[][] arr;
    static boolean[][][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        visited = new boolean[R][C][K+1]; // K+1fj tmwkd

        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Node ( 0, 0, 0, 0));
        if(minMove ==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minMove);
    }

    static void bfs(Node node){

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.r][node.c][node.kCnt] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.r==R-1 && cur.c == C-1){
                minMove = Math.min(minMove, cur.move);
                return;
            }

            // 1) 원숭이대로 이동
            for(int d=0; d<4; d++){
                int nr = cur.r + dr[d];
                int nc =cur.c + dc[d];

                if(isPossible(nr, nc) && !visited[nr][nc][cur.kCnt] && arr[nr][nc]==0){
                    visited[nr][nc][cur.kCnt]=true;
                    q.add(new Node(nr, nc, cur.kCnt, cur.move+1));
                }
            }
            // 2) 말처럼 이동
            if(cur.kCnt < K ){ // 말처럼 이동할 기회가 남았다면
                for(int d=0; d<8; d++){
                    int nr = cur.r + hdr[d];
                    int nc = cur.c + hdc[d];

                    if(isPossible(nr, nc)&& !visited[nr][nc][cur.kCnt+1] && arr[nr][nc]==0){
                        visited[nr][nc][cur.kCnt+1] = true;
                        q.add(new Node(nr, nc, cur.kCnt+1, cur.move+1));
                    }
                }
            }
        }
    }


    static boolean isPossible(int nr, int nc){
        if(nr<0 || nc<0 || nr>=R || nc>=C) return false;
        return true;
    }
}