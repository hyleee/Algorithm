

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr;
	static int N;
	static int maxCnt;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			maxCnt=0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			eatCheese(0);
			sb.append("#"+t+" "+maxCnt+"\n");
		}
		System.out.println(sb);
	}
	
	
	// x일차마다 요정이 치즈를 먹도록
	static void eatCheese(int x) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == x) {
					arr[i][j] = 0;
				}
			}
		}

		visit = new boolean[N][N]; // 매일매일 방문 배열 초기화
		int cnt = 0; // 덩어리 개수

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && arr[i][j] > 0) {
					cnt++;
					dfs(i, j);
				}
			}
		}

		maxCnt = Math.max(maxCnt, cnt);
		if(x==100) {
			return;
		} else {
			eatCheese(x + 1);			
		}
	}
	
	
	// 한 덩어리 내부를 다 방문해야 끝나는
	static void dfs(int r, int c) {
		visit[r][c] = true;

		if (arr[r][c] > 0) {

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (isPossible(nr, nc) && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}

	// 범위 밖이거나 덩어리 내부 범위가 아니면 false
	static boolean isPossible(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc]==0)
			return false;
		return true;
	}
}
