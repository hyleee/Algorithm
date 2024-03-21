import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int N, M;
	static int[] dr = { -1, 0, 1, 0 }; // 북동남서
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		clean(r, c, dir);
		System.out.println(cnt);
	}

	static void clean(int r, int c, int dir) {
		if (arr[r][c] == 0) { // 현재 칸이 청소되지 않았으면
			arr[r][c] = 2; // 현재 칸 청소
			cnt++; // 청소한 공간의 개수 증가
		}

		for (int i = 0; i < 4; i++) {
			int nd = (dir + 3 -i) % 4; // 반시계 방향으로 90도 회전
			int nr = r + dr[nd];
			int nc = c + dc[nd];

			if (isPossible(nr, nc) && arr[nr][nc] == 0) { // 상하좌우 중 청소되지 않은 칸 발견
				clean(nr, nc, nd); // 한 칸 전진 후 재귀
				return;
			}
		}

		// 상하좌우 중 청소되지 않은 칸이 없을 경우 아래 코드 실행
		// 바라보는 방향을 유지한 채로 한 칸 후진
		int nr = r + dr[(dir + 2) % 4];
		int nc = c + dc[(dir + 2) % 4];
		if (isPossible(nr, nc)) { // 후진할 수 있다면 재귀
			clean(nr, nc, dir); // 바라보는 방향 유지한채로 후진
		} 
		// 후진이 불가능하다면 작동을 멈춘다.
	}

	static boolean isPossible(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc] == 1)
			return false;
		return true;
	}
}