import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
		
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// 상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static boolean[][] visited;
	static int[][] arr;
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int C = Integer.parseInt(st.nextToken());
	        int R = Integer.parseInt(st.nextToken());

	        int K = Integer.parseInt(br.readLine());

	        if (K > C * R) {
	            System.out.println(0);
	            return;
	        }

	        int dx[] = {-1, 0, 1, 0};
	        int dy[] = {0, 1, 0, -1};

	        boolean[][] visit = new boolean[R][C];

	        int cnt = 0, x = R - 1, y = 0, dir = 0;
	        while (++cnt != K) {
	            visit[x][y] = true;
	            int nx = x + dx[dir];
	            int ny = y + dy[dir];

	            if (nx < 0 || ny < 0 || nx >= R || ny >= C || visit[nx][ny]) {
	                dir = ++dir % 4;
	                nx = x + dx[dir];
	                ny = y + dy[dir];
	            }

	            x = nx;
	            y = ny;
	        }

	        System.out.println((y + 1) + " " + (R - x));
	    }
	
//	public static void main(String[] args) throws IOException {
//		
//		st = new StringTokenizer(br.readLine());
//		int C = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//		int N = Integer.parseInt(br.readLine());
//		
//		if(N>C*R) {
//			System.out.println(0);
//			return;
//		}
//		
//		int r=R-1, c=0, num=0;
//		int nr=0, nc=0;
//		int idx=0;
//		
//		visited = new boolean[R][C];
//		arr = new int[R][C];
//		
//		for(boolean v[] : visited) Arrays.fill(v, false);
//		
//		while(++num<N) {
//			visited[nr][nc] = true;
//
//			nr = r+ dr[idx];
//			nc = c+ dc[idx];
//			
//			if (nc<0 || nc>=C || nr<0 || nr>=R || visited[nr][nc]) {
//				// 범위 밖이거나, 이미 방문했으면 방향 전환
//				idx = (idx+1)%4;
//				nr = r + dr[idx];
//				nc = c + dc[idx];
//			}
//			
//			r= nr;
//			c= nc;
//		}
//
//		System.out.println((nc+1)+" "+(nr+1));
//	}
}
