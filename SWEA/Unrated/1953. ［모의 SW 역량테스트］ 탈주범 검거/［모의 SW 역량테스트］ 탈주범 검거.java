import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st1, st2;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static boolean[][] visited;
	static int N, M, R, C, L;
	static int cnt, time;

	// 상 우 하 좌
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static final int[][] type = { { 0, 0, 0, 0 }, // 1-based를 위해 버리는 줄
			{ 1, 1, 1, 1 }, // 상우하좌 모두 가능
			{ 1, 0, 1, 0 },
			{ 0, 1, 0, 1 }, 
			{ 1, 1, 0, 0 }, 
			{ 0, 1, 1, 0 }, 
			{ 0, 0, 1, 1 },
			{ 1, 0, 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			M = Integer.parseInt(st1.nextToken());
			R = Integer.parseInt(st1.nextToken());
			C = Integer.parseInt(st1.nextToken());
			L = Integer.parseInt(st1.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];

			// 1. 배열 입력 받기
			for (int n = 0; n < N; n++) {
				st2 = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					arr[n][m] = Integer.parseInt(st2.nextToken());
				}
			}
			int r = R, c = C; // 현재 위치 = 시작 위치
			int res = BFS( r, c);
			sb.append("#" + t + " " + cnt+"\n");
		}
		System.out.println(sb);
	}

	static int BFS(int r, int c) {
		cnt=1; // 도착 가능 칸 수
		time=1; // 몇시간?
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r,c));
		visited[r][c] =true;

		
		while(!q.isEmpty()) {
			if(time==L) break;
			int size = q.size();
			while(size-- >0) {
				Pos out = q.poll();
				int[] dir = type[arr[out.r][out.c]]; // 상우하좌에 대한 가능 여부가 담겨있는 배열
				
				for(int d=0; d<dir.length; d++) {
					if(dir[d]==0) continue;
					// 1. nr, nc 일단 만들기
					int nr = out.r + dr[d];
					int nc = out.c + dc[d];
					
					// 2. 조건 검사 - 배열 안에 있는지, 파이프가 있는지, 이미 방문한 곳인지, 그 방향으로 파이프가 뚫려있는지
					// 그 방향으로 뚫려있는지 : type[arr[nr][nc]][(d+2)%4]==1
					if(nr <0 || nc<0 || nr>=N || nc>=M) continue;
					if(arr[nr][nc]==0) continue;
					if(visited[nr][nc]) continue;
					if(type[arr[nr][nc]][(d+2)%4]==1) {
						// 방문 처리
						visited[nr][nc]=true;
						q.add(new Pos(nr,nc));
						cnt++;
					}
				}
			}
			time++;
		}
		return cnt;
	}

	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}