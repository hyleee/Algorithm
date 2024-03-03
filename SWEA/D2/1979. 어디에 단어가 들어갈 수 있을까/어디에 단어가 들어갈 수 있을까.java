import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int N, K;
    static int[] dr = { 1, 0 };
    static int[] dc = { 0, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            int totalCnt = 0;
            for (int r = 0; r < N; r++) { // 가로 검사
                for (int c = 0; c < N; c++) {
                    if (arr[r][c] == 1)
                        cnt++;
                    else if (cnt >= 1 && arr[r][c] == 0) {
                        if (cnt == K)
                            totalCnt++;
                        cnt = 0;
                    }
                }
                if (cnt == K)
                    totalCnt++;
                cnt = 0;
            }

            for (int c = 0; c < N; c++) { // 세로 검사
                for (int r = 0; r < N; r++) {
                    if (arr[r][c] == 1)
                        cnt++;
                    else if (cnt >= 1 && arr[r][c] == 0) {
                        if (cnt == K)
                            totalCnt++;
                        cnt = 0;
                    }
                }
                if (cnt == K)
                    totalCnt++;
                cnt = 0;
            }

            sb.append("#" + t + " " + totalCnt+"\n");
        }
        System.out.println(sb);
    }
}