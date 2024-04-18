import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Easy {
	int r;
	int c;

	public Easy(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

}

public class Main {

	static int[][] map;
	static int[][] dis;
	static int N, M;
	static int startR, startC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dis = new int[N][M];
		for (int n = 0; n < N; n++) {
			Arrays.fill(dis[n], -1);
		}

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if (map[n][m] == 2) {
					startR = n;
					startC = m;
				}
			}
		}

		visited = new boolean[N][M];
		getDistance(startR, startC);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					sb.append(0 + " ");
					continue;
				}
				sb.append(dis[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void getDistance(int r, int c) {
		// r,c 목표 지점에 대한 처리
		dis[r][c] = 0;
		visited[r][c] = true;
		// 큐 준비
		Queue<Easy> q = new LinkedList<>(); 
		q.add(new Easy(r, c));
		
		//bfs 탐색
		while(!q.isEmpty()) {
			Easy cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				int curDis = dis[cur.r][cur.c];
				
				if (isPossible(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					dis[nr][nc] = curDis+1;
					q.add(new Easy(nr, nc));
				}
			}			
		}
	}

	static boolean isPossible(int nr, int nc) {

		if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0) {
			return false;
		}
		return true;
	}
}