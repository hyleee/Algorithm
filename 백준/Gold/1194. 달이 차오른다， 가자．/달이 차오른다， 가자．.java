import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Moon {
	int r;
	int c;
	int move;
	int key;

	public Moon(int r, int c, int move, int key) {
		this.r = r;
		this.c = c;
		this.move = move;
		this.key = key;
	}

}

public class Main {

	static int N, M;
	static char[][] map;
	static boolean visited[][][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][64]; // a~f까지 키 소유 여부
		int startR=0, startC=0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					startR = i;
					startC = j;
				}
			}
		}

		bfs(startR, startC);
	}

	private static void bfs(int r, int c) {
		Queue<Moon> q = new LinkedList<>();
		q.offer(new Moon(r, c, 0, 0));
		visited[r][c][0] = true;
		map[r][c] = '.';

		while (!q.isEmpty()) {
			Moon cur = q.poll();

			// base condition : 출구 도착
			if (map[cur.r][cur.c] == '1') {
				System.out.println(cur.move);
				return;
			}

			// recursive condition
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '#' || visited[nr][nc][cur.key]) {
					continue;
				}

				if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z') { // 1) 열쇠라면
					int key = cur.key | (1<< (map[nr][nc]-'a'));
					q.offer(new Moon(nr, nc, cur.move+1, key));
					visited[nr][nc][key]=true;
				} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') { // 2) 문이라면
					boolean flag = (cur.key & (1 << (map[nr][nc]-'A')))!=0; 
					if(flag) { // 그 문에 해당하는 키가 있다면
						q.offer(new Moon(nr, nc, cur.move+1, cur.key));
						visited[nr][nc][cur.key]= true;
					}
				} else { // 3) . or 도착지
					visited[nr][nc][cur.key] = true;
					q.offer(new Moon(nr, nc, cur.move + 1, cur.key));
				}
			}

		}
		System.out.println(-1); // 출구를 발견하지 못한 경우
	}
}