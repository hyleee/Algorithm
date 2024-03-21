import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static char[][] arr;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new char[N][M];

			for (int n = 0; n < N; n++) {
				String str = br.readLine();
				for (int m = 0; m < M; m++) {
					arr[n][m] = str.charAt(m);
				}
			}

			int minChange = Integer.MAX_VALUE;

			for (int w = 0; w < N - 2; w++) {
				for (int b = w + 1; b < N - 1; b++) {
					int changeCnt = 0; // 해당턴 cnt 저장
					for (int i = 0; i <= w; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'W')
								changeCnt++;
						}
					}

					for (int i = w + 1; i <= b; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'B')
								changeCnt++;
						}
					}

					for (int i = b + 1; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (arr[i][j] != 'R')
								changeCnt++;
						}
					}
					
					minChange = Math.min(changeCnt, minChange);
				}
			}

			System.out.println("#" + t + " " + minChange);

			// 바꾸는게 적은 걸 세려고하지 말고, 유지시킬 수 있는게 많은 걸로 생각을 바꾸자

			// 첫줄은 다 W로
			// 마지막줄은 다 R로

			// W는 n=0 부터 n=N-3 까지 가능
			// B는 n=1 부터 n=N-2 까지 가능
			// R는 n=2 부터 n=N-1 까지 가능
		}
	}
}