import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
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
					if (arr[r][c] == 1) {
						if (c == 0 || arr[r][c - 1] == 0) { // 이전 열이 검은색인 경우에만 cnt 증가
							cnt = 1;
							while (isPossible(r, c + cnt)) {
								cnt++;
							}
							if (cnt == K) {
								totalCnt++;
							}
						}
					}
				}
			}

			cnt = 0; // 세로 방향으로 탐색하기 위해 cnt 초기화
			for (int c = 0; c < N; c++) { // 세로 검사
				for (int r = 0; r < N; r++) {
					if (arr[r][c] == 1) {
						if (r == 0 || arr[r - 1][c] == 0) { // 이전 행이 검은색인 경우에만 cnt 증가
							cnt = 1;
							while (isPossible(r+cnt, c)) {
								cnt++;
							}
							if (cnt == K) {
								totalCnt++;
							}
						}
					}
				}
			}

			sb.append("#").append(t).append(" ").append(totalCnt).append("\n");
		}
		System.out.println(sb);
	}

	static boolean isPossible(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] == 0) {
			return false;
		}
		return true;
	}
}