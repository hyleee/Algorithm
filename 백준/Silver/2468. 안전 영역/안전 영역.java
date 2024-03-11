import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class LocRC{
	int r;
	int c;
	
	LocRC(int r, int c){
		this.r=r;
		this.c=c;
	}
}

public class Main {
	
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int safeCnt;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		int maxHeight =0;
		int maxCnt=0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, arr[i][j]);
			}
		}
		
		for(int h=0; h<=maxHeight; h++) {
			visited = new boolean[N][N];
			safeCnt =0; // 안전 영역 개수
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && arr[i][j]>h) {
						bfs(i,j,h);  // 한 영역 모두 탐색
						safeCnt++; // 영역 개수 +1
					}
				}
			}
			maxCnt = Math.max(maxCnt, safeCnt);
		}
		System.out.println(maxCnt);
	}
	
	static void bfs(int r, int c, int height) {
		Queue<LocRC> q = new LinkedList<>();
		q.add(new LocRC(r, c));
		visited[r][c]=true;
		
		while(!q.isEmpty()) {
			LocRC current = q.poll();
			for(int i=0; i<4; i++) {
				int nr = current.r+ dr[i];
				int nc = current.c+ dc[i];
				
				if(isPossible(nr,nc) && !visited[nr][nc]) {
					// 범위 안에 있는데, 아직 방문하지 않았다면
					if(arr[nr][nc]>height) {
						visited[nr][nc] = true;
						q.add(new LocRC(nr,nc));
					}
				}
			}
		}
		
	}
	
	static boolean isPossible(int nr, int nc) {
		if(nr<0 || nc<0 || nr>=N || nc>=N) return false;
		return true;
	}
}