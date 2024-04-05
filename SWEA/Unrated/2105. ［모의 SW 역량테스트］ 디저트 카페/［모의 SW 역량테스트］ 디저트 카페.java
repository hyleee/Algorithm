import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;
    static int N;

    //
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};
    static int maxDessert;
    static int startR, startC;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
//            numCheck = new boolean[101];
//            maxDessert = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            maxDessert = -1;
            boolean[] visit;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visit = new boolean[101];
                    startR = i;
                    startC = j;
                    dfs(i, j, 0, 0, visit);
                }
            }
            sb.append("#" + t + " " + maxDessert + "\n");
        }
        System.out.println(sb);
    }
    // 대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아와야 한다.
    // 카페 투어 중 같은 숫자의 디저트를 팔고 있는 카페가 있으면 안된다.

    // [직전 좌표를 기억하는 방식]
    static void dfs(int r, int c, int cnt, int dir, boolean[] visit) {
//            int nr = r + dr[dir];
//            int nc = c + dc[dir];

        // 한 바퀴 돌았을 때 갱신
        if (r == startR && c == startC && dir == 3) {
            maxDessert = Math.max(maxDessert, cnt);
            return;
        }
        // 이미 dir 0~3 모두 고려했는데, 한 방향 당 1회 이상 직진하지 못했다면 출발점을 못 지날 수도 있잖아
        if (dir == 4) return;

        // 1) 해당 방향으로 더 진행하는 경우, 미리 방문 처리
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if (isPossible(nr, nc) && !visit[map[nr][nc]]) {
            visit[map[nr][nc]] = true;
            dfs(nr, nc, cnt + 1, dir, visit);
            visit[map[nr][nc]] = false;
        }

        // 2) 해당 방향으로 더 진행하지 않고 이제 방향 전환 하는경우
        if (dir < 3) {
            nr = r + dr[dir + 1];
            nc = c + dc[dir + 1];

            if (isPossible(nr, nc) && !visit[map[nr][nc]]) {
                visit[map[nr][nc]] = true;
                dfs(nr, nc, cnt + 1, dir + 1, visit);
                visit[map[nr][nc]] = false;
            }
        }
    }

    static boolean isPossible(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= N || nc >= N) return false;
        return true;
    }
}




    // [방향 자체를 기억하는 방식] - 실패!!!!
    // dir : 다음 호출에서 진행할 방향 !.
    // dirCnt : 해당 방향으로 진행한 횟수 (0 이라면 각 방향에서 적어도 반드시 한 번은 진행하도록)
//    static void eatDessert(int r, int c, boolean[] numCheck, int sum, int dir, int dirCnt, int startR, int startC){
////        System.out.println("eatDessert");
//
//        if(dir==3 && r==startR && c==startC){ // 한 바퀴 다 돌아서 출발좌표로 돌아왔다면
//            maxDessert = Math.max(maxDessert, sum); // 최대 디저트 갱신
//            return;
//        }
//
//        // r, c 방문 처리
//        numCheck[map[r][c]] = true; // 디저트 수 체크
//        sum += map[r][c];
//
//        int nr = r + dr[dir];
//        int nc = c+ dc[dir];
//
//        if(isPossible(nr, nc)) { // 범위 안
//            if (!numCheck[map[nr][nc]]) { // 아직 나오지 않은 디저트 숫자
//                // 1. (dirCnt >=1 이라면) 방향 전환하는 경우
//                if (dirCnt >= 1 && dir!=3){
////                    System.out.println("방향 전환");
//                    eatDessert(nr, nc, numCheck, sum, dir + 1, 0, startR, startC);
//                }
//                // 2. 방향 전환 하지 않고 계속 진행하는 경우
////                System.out.println("계속 진행");
//                eatDessert(nr, nc, numCheck, sum, dir, dirCnt + 1, startR, startC);
//            }
//        }
//    }