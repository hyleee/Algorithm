import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// camera 각도 별 3차원 배열 생성해서 관리


class Camera {
	int r;
	int c;
	int num;

	public Camera(int r, int c, int num) {
		super();
		this.r = r;
		this.c = c;
		this.num = num;
	}
}

public class Main {

	static int minArea = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 }; // 상하우좌
	static int[] dc = { 0, 0, 1, -1 };
	static int N, M;
	static List<Camera> camList = new ArrayList<>();
	static int[][][] angle = {{{0}},{{0}, {1}, {2}, {3}},{{2,3}, {0,1}}, {{0,3}, {1,3}, {1,2}, {0,2}},{{0,2,3}, {0,1,3}, {1,2,3}, {0,1,2}},{{0,1,2,3}}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				if (arr[n][m] >= 1 && arr[n][m] <= 5) {
					camList.add(new Camera(n, m, arr[n][m]));
				}
			}
		}
		backTracking(0, arr);
		System.out.println(minArea);
	}

	static void backTracking(int idx, int[][] map) {
		
		if (idx == camList.size()) { // 모든 카메라를 다 처리했다면 끝
			minArea = Math.min(minArea, cntZero(map)); // 최솟값 갱신
			return;
		}

		Camera cam = camList.get(idx);
		
		// 여기서부터가 내가 직접 작성하지 못한 부분
		for(int i=0; i<angle[cam.num].length; i++) { // 해당 캠이 가질 수 있는 경우의 수에 대해 
			
			int[][] copyMap = copyArr(map);
			
			for(int j=0; j<angle[cam.num][i].length; j++) {  // 해당 경우의 수에 속하는 모든 각도에 대해
				int dir = angle[cam.num][i][j];
				
				int nr = cam.r + dr[dir];
				int nc = cam.c + dc[dir];
				
				while(true) {
					if (isPossible(nr, nc) && map[nr][nc] != 6) {
						copyMap[nr][nc] = -1;
						nr += dr[dir];
						nc += dc[dir];
					} else {
						break;
					}
				}
			} // 해당 경우의 수의 모든 각도 처리 끝
			backTracking(idx+1, copyMap);
		} // 모든 경우의 수 처리 끝
	}

	static boolean isPossible(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M)
			return false;
		return true;
	}
	
	static int cntZero(int[][] map) {
		int area = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					area++;
			}
		}
		return area;
	}
	
	static int[][] copyArr(int[][] map){
		int[][] copyMap = new int[N][M];
		for(int n=0; n<N; n++) {
			copyMap[n] = map[n].clone();
		}
		return copyMap;
	}
	

	//	static void go(int dir, int r, int c, int[][] map) {
//		
//		while (true) {
//			int nr = r + dr[dir];
//			int nc = c + dc[dir];
//			
//			// 범위 내에 있고, 벽이 아니라면
//			if (isPossible(nr, nc) && map[nr][nc] != 6) {
//				// 더 진행.
//				r = nr;
//				c = nc;
//				
//				// i) 0이면
//				if (arr[nr][nc] == 0)
//					map[nr][nc] = 7;
//				// ii) CCTV이면
//			} else { // 범위 밖이거나, 벽이면
//				break; // 진행 그만
//			}
//		}
//	}
	

	
	//	// 각 CCTV 번호에 맞는 방향의 감시 가능 영역에 표시
//	static void getArea1(int cctvNum, int r, int c, int[][] map) {
//		if (cctvNum == 1) {
//			go(2, r, c, map);
//		} else if (cctvNum == 2) {
//			go(2, r, c, map);
//			go(3, r, c, map);
//		} else if (cctvNum == 3) {
//			go(0, r, c, map);
//			go(2, r, c, map);
//		} else if (cctvNum == 4) {
//			go(0, r, c, map);
//			go(2, r, c, map);
//			go(3, r, c, map);
//		} else if (cctvNum == 5) {
//			go(0, r, c, map);
//			go(1, r, c, map);
//			go(2, r, c, map);
//			go(3, r, c, map);
//		}
//	}
//
//	// 각 CCTV 번호에 맞는 방향의 감시 가능 영역에 표시
//	// 시계방향 90도 회전
//	// 상하우좌
//	static void getArea2(int cctvNum, int r, int c, int[][] map) {
//		if (cctvNum == 1) {
//			go(1, r, c, map);
//		} else if (cctvNum == 2) {
//			go(0, r, c, map);
//			go(1, r, c, map);
//		} else if (cctvNum == 3) {
//			go(1, r, c, map);
//			go(2, r, c, map);
//		} else if (cctvNum == 4) {
//			go(0, r, c, map);
//			go(1, r, c, map);
//			go(2, r, c, map);
//		} else if (cctvNum == 5) {
//			go(0, r, c, map);
//			go(1, r, c, map);
//			go(2, r, c, map);
//			go(3, r, c, map);
//		}
//	}
//
//	// 각 CCTV 번호에 맞는 방향의 감시 가능 영역에 표시
//	// 시계방향 180도 회전
//	// 상하우좌
//	static void getArea3(int cctvNum, int r, int c, int[][] map) {
//		if (cctvNum == 1) {
//			go(3, r, c, map);
//		} else if (cctvNum == 2) {
//			go(2, r, c, map);
//			go(3, r, c, map);
//		} else if (cctvNum == 3) {
//			go(1, r, c, map);
//			go(3, r, c, map);
//		} else if (cctvNum == 4) {
//			go(1, r, c, map);
//			go(2, r, c, map);
//			go(3, r, c, map);
//		} else if (cctvNum == 5) {
//			go(0, r, c, map);
//			go(1, r, c, map);
//			go(2, r, c, map);
//			go(3, r, c, map);
//		}
//	}
//
//	// 각 CCTV 번호에 맞는 방향의 감시 가능 영역에 표시
//	// 시계방향 270도 회전
//	// 상하우좌
//	static void getArea4(int cctvNum, int r, int c, int[][] map) {
//		if (cctvNum == 1) {
//			go(0, r, c, map);
//		} else if (cctvNum == 2) {
//			go(0, r, c, map);
//			go(1, r, c, map);
//		} else if (cctvNum == 3) {
//			go(0, r, c, map);
//			go(3, r, c, map);
//		} else if (cctvNum == 4) {
//			go(0, r, c, map);
//			go(1, r, c, map);
//			go(3, r, c, map);
//		} else if (cctvNum == 5) {
//			go(0, r, c, map);
//			go(1, r, c, map);
//			go(2, r, c, map);
//			go(3, r, c, map);
//		}
//	}

}