import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location{
	int r;
	int c;
	
	public Location(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, cheese, time;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<Integer> cheeseNum = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		cheese=0; time=0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]==1) cheese++;
			}
		}
		int firstCheeseNum = cheese; // 예외처리를  위해 첫 치즈 개수는 따로 저장
		
		while(cheese!=0) {
			for(int i=0; i<N; i++)
				Arrays.fill(visited[i], false);

			bfs(0,0);
			
		}
		
		// 1시간 만에 없어지는 경우는 따로 처리
		
		System.out.println(time);
		if(cheeseNum.size()==0) System.out.println(firstCheeseNum);
		else System.out.println(cheeseNum.get(cheeseNum.size()-1));

	}

	static void bfs(int inputR, int inputC) {
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(inputR, inputC));
		
		while(!q.isEmpty()) {
			Location current = q.poll();   // current는 항상 (예비 or 지금 당장) 빈 칸
			
			for (int d = 0; d < 4; d++) {
				int r = current.r;
				int c = current.c;
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(isPossible(nr,nc)) {
					if(!visited[nr][nc]) { // 방문했다면 넘기고, 방문 안했다면
						visited[nr][nc]=true;
						if(arr[nr][nc]==1) { // 치즈였다면
							arr[nr][nc]=2; // 이따가 녹일 칸이라고 표시해두기
						}else { // 빈 칸이었다면
							q.add(new Location(nr, nc));
						}
					}
				}
			} //for (int d = 0; d < 4; d++)
		} //while(!q.isEmpty()) 
		meltingCheese();
		if(cheese!=0) cheeseNum.add(cheese);
	}
	
	
	static void meltingCheese() {
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(arr[n][m]==2) {
					arr[n][m]=0;
					cheese--;
				} 
			}
		}
		time++;
	}
	
	static boolean isPossible(int nr, int nc) {
		if(nr<0 || nc<0 || nr>=N || nc>=M) return false;
		return true;
	}
}