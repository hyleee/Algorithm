import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc {
	int r;
	int c;
	int dis;
	int wall; // 벽을 부순 상태를 표시

	public Loc(int r, int c, int dis, int wall) {
		super();
		this.r = r;
		this.c = c;
		this.dis = dis;
		this.wall = wall;
	}
}

// 틀린 포인트
// 1) 벽일때는 방문 여부 말고 breakCnt를 확인해야함
// 2) 벽을 부쉈을 때와 부수지 않았을 때의 방문 배열이 서로 영향을 미치지 않기 위해 3차원 방문 배열 활용
// 3) Loc class에 거리, 벽 부순 횟수 모두 포함시켜야함!!!

public class Main {
	
	static int[][] map;
	static boolean[][][] visited;
	static int N, M;
	static int minDis = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		// 벽을 부쉈을 때와 부수지 않았을 때의 방문 배열이 서로 영향을 미치지 않기 위해
		
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = str.charAt(m)-'0';
			}
		}
		

        bfs(0, 0, 1, 0); // 시작점에 대한 bfs 호출

        if (minDis == Integer.MAX_VALUE) { // 갱신되지 않았다면
            System.out.println(-1); // 도달할 수 없는 경우
        } else {
            System.out.println(minDis);
        }
		
	}
	
	
	static void bfs(int r, int c, int dis, int wall) {
		Queue<Loc> q = new LinkedList();
		visited[r][c][wall] = true;
		q.offer(new Loc(r, c, dis, wall));
		
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			
			if(cur.r==N-1 && cur.c==M-1) {
				minDis = Math.min(minDis, cur.dis);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc >= M) continue;
				if(map[nr][nc]==0 && ! visited[nr][nc][cur.wall]) {
					// 벽을 부수지 않고 이동하는 경우
					visited[nr][nc][cur.wall] = true;
					q.offer(new Loc(nr, nc, cur.dis+1, cur.wall));
				} else if(map[nr][nc]==1 && cur.wall==0) { // 벽일때는 방문 여부 말고 breakCnt를 확인해야함
					// 벽을 부수고 이동하는 경우
					visited[nr][nc][1] = true;
					q.offer(new Loc(nr, nc, cur.dis+1, 1));
				}
			}
		}
	}

}