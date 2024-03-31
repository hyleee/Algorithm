import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Island{
	
	int r;
	int c;
	int cnt;
	
	public Island(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main {	
	
	static int islandNum;
	static int N;
	static int[][] map;
	static boolean[][] checkIsland;
	static int[] dr = {-1, 1, 0,0};
	static int[] dc = {0,0,-1,1};
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		checkIsland = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		groupIsland();
		for(int i=1; i<= islandNum; i++) {
			int[][] arr = map.clone();
			bfs(i, arr);
			// 원본 배열은 해치지 않으면서, 각 섬에서 지을 수 있는 다리 모두 지어보기.
		}
		
		System.out.println(res);
		
	}
	
	// 각 섬에 번호 부여해서 섬을 구별할 수 있도록
	static void groupIsland() {
		
		islandNum =1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!checkIsland[i][j] && map[i][j]!=0) {
					dfs(i,j, islandNum);
					islandNum++;
				}
			}
		}
	}
	
	
	// 재귀를 통해 해당 섬 내부 전체 방문
	private static void dfs(int r, int c, int islandNum) {
		checkIsland[r][c] = true;
		map[r][c] = islandNum;
		
		for(int d=0; d<4; d++) {
			int nr = r+ dr[d];
			int nc = c+ dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			if(map[nr][nc]!=0 && !checkIsland[nr][nc]) dfs(nr, nc, islandNum);
		}
	}
	
	// 섬을 넓혀나가는 작업. 이때 cnt 로 다리의 길이를 저장
	static void bfs(int islandNum, int[][] arr) {
		boolean[][] visited = new boolean[N][N];
		Queue<Island> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == islandNum) {
					q.add(new Island(i,j,0));
					visited[i][j]= true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Island cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				
				// 1) 이동한 값이 다른 섬일 경우 == 다리를 완성
				if(arr[nr][nc]!=islandNum && arr[nr][nc]!=0) {
					// 해당 다리 길이가 최소 길이면 갱신
					if(res > cur.cnt && cur.cnt!=0) res = cur.cnt;
				} else { 
				// 2) 이동한 값이 바다이고, 아직 방문하지 않았을 경우
					if(arr[nr][nc]==0 && !visited[nr][nc]) {
						// 확장을 이어나간다.
						visited[nr][nc] = true;
						q.add(new Island(nr, nc, cur.cnt+1));
					}
				}
			}
		}
		
	}

}