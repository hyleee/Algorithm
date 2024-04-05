import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, K;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visit;
    static int maxLen;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            int maxHeight = 1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(maxHeight<map[i][j]) maxHeight = map[i][j];
                }
            }

            maxLen = 1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]==maxHeight){
                        visit = new boolean[N][N];
                        visit[i][j]= true; // 출발점 방문 처리
                        dfs(i,j,1, true);
                    }
                }
            }
            sb.append("#"+t+" "+maxLen+"\n");
        }
        System.out.println(sb);
    }

    static void dfs(int r, int c, int len, boolean canDig){

        maxLen = Math.max(maxLen, len);

        for(int d=0; d<4; d++){
            int nr = r+ dr[d];
            int nc = c+ dc[d];

            if(!isPossible(nr, nc) || visit[nr][nc] ) continue;

            // 1) 공사 없이 낮은 곳으로 이동
            if(map[r][c] > map[nr][nc]){
                visit[nr][nc] = true;
                dfs(nr, nc, len+1, canDig);
                visit[nr][nc] = false;
            } else if(canDig && map[r][c] > map[nr][nc]-K){
                // 2) 공사해서 가능하면 공사 해서 낮은 곳으로 이동
                int tmp = map[nr][nc];
                map[nr][nc] = map[r][c]-1;
                visit[nr][nc]= true;
                dfs(nr, nc, len+1, false);
                //원상복구
                map[nr][nc] = tmp;
                visit[nr][nc] = false;
            }
            // 3) 아무것도 할 수 없는 경우 -> 처리 X 자동 continue;
        }
    }

    static boolean isPossible(int nr, int nc){
        if(nr<0 || nc<0 || nr>=N || nc>=N) return false;
        return true;
    }
}