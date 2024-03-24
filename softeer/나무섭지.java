package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 만약 남우가 출구에 도달하는 데 필요한 이동 횟수(goalCnt)가 
// 어떤 유령과 출구 사이의 거리보다 크거나 같다면, 
// 유령에게 잡힐 가능성이 있으므로 탈출이 불가능한 것으로 판단

class Loc {

	int r;
	int c;

	public Loc(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class 나무섭지 {

	static int N, M;
	static int[][] arr;
	static int goalCnt=-1, moveCnt =0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Loc goal = null;
	static Loc namwoo = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		List<Loc> ghosts = new ArrayList<>();

		// 'D'(출구): map에 2로 표시하고, goal에 위치 저장
		// '#'(벽): map에 1로 표시
		// 'G'(유령): ghosts 리스트에 위치 추가
		// 'N'(남우): bfs 탐색에 대입

		for (int i = 0; i < N; i++) {
			String str =br.readLine();
			for (int j = 0; j < M; j++) {
				char tmp = str.charAt(j);
				if (tmp == 'D') {
					arr[i][j] = 2;
					goal = new Loc(i,j);
				} else if (tmp == '#') {
					arr[i][j] = 1;
				} else if (tmp == 'G') {
					ghosts.add(new Loc(i, j));
				} else if (tmp == 'N') {
					namwoo = new Loc(i,j);
				}
			}
		}

		bfs(namwoo);
		
		String answer ="No";
		int minDis = calculateMinDis(ghosts);
		if(goalCnt>=0) { // 남우가 출구에 닿을 수 있다면
			// 유령보다 빨리 도착할 수 있는지 체크
			if(minDis > goalCnt) answer= "Yes";
		} 
		
		System.out.println(answer);
	}

	// 남우가 출구를 찾기 위한 BFS
	static void bfs(Loc loc) {
		Queue<Loc> q = new LinkedList<>();
		q.add(loc);

		while (!q.isEmpty()) {
			
			int qSize = q.size();
			moveCnt++;
			
			// 이 루프는 현재 레벨에 있는 노드만큼만 반복하게 됨
			// 따라서, 큐에 새로운 노드를 추가해도, 현재 진행중인 for 루프의 반복 횟수에는 영향 X
			// 현재 레벨의 노드들을 처리하는 동안에 찾아낸 다음 레벨의 노드들은
			// 현재 for 루프가 끝난 후에 처리됨
			
			for(int i=0; i<qSize; i++) {
				Loc cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if (isPossible(nr, nc) ) {
						if(arr[nr][nc]==2) { // 출구를 만났다면
							goalCnt = moveCnt;
							return;
						}
						// 출구는 아니지만 접근 가능하다면
						q.add(new Loc(nr, nc));
						arr[nr][nc] =1; // 이미 방문한 점은 벽으로 취급 
					}	
				}
			}
		}
	}

	static boolean isPossible(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc]==1)
//			배열 밖 범위 이거나 벽일 때는 이동 불가능
			return false;
		return true;
	}
	
	
	// 유령~출구까지의 맨해튼 거리
	static int calculateMinDis(List<Loc> ghosts) {
		
		int minDis = Integer.MAX_VALUE;
		
		for(int i=0; i<ghosts.size(); i++) {
			Loc ghost = ghosts.get(i);
			int dis = Math.abs(ghost.r - goal.r) + Math.abs(ghost.c - goal.c);
			minDis = Math.min(minDis, dis);
		}
		
		return minDis;
	}
}
