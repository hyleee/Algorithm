import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc {
	int r;
	int c;

	public Loc(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main {

	static int N, L, R;
	static int[][] people;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0,0, -1, 1 };
	static List<Loc> moveArea; // 인구이동이 필요한 노드
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		people = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (true) {
			visited = new boolean[N][N];
			boolean isMove = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if(bfs(i,j)) {
							isMove = true;							
						}
					}
				}
			}
			
			if(!isMove) break;
			cnt++;
		}
		System.out.println(cnt);
	}

	static boolean bfs(int r, int c) {
//		System.out.println("bfs");

		Queue<Loc> q = new LinkedList<>();
		q.offer(new Loc(r, c));

		moveArea = new ArrayList<>();
		moveArea.add(new Loc(r, c));

		int areaSum = people[r][c];
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Loc cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (!visited[nr][nc]) {
					int diff = Math.abs(people[nr][nc] - people[cur.r][cur.c]);
					if (diff >= L && diff <= R) {
						areaSum += people[nr][nc];
						moveArea.add(new Loc(nr, nc));
						visited[nr][nc] = true; // 방문 처리
						q.offer(new Loc(nr, nc));
					}
				}
			}
		}

		if (moveArea.size() > 1) {
			int avg = areaSum / moveArea.size();
			for (Loc loc : moveArea) {
				people[loc.r][loc.c] = avg;
			}
			return true;
		}
		return false;
	}
}