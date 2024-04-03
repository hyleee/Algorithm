import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] wheel;
	static int[] dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		wheel = new int[5][8];

		for (int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = str.charAt(j) - '0';
			}
		}

		int K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			checkDir(num, d);
			turn();
		}
		
		System.out.println(getScore());

	}

	// 1) 바퀴 별 회전 방향을 저장
	static void checkDir(int num, int d) {

		dir = new int[5];
		dir[num] = d;

		// 회전 바퀴를 시작으로 양옆으로 퍼져나가는 방향으로 확인

		// 좌
		for (int i = num - 1; i >= 1; i--) {
			if (wheel[i + 1][6] != wheel[i][2]) {
				dir[i] = -dir[i + 1];
			} else { // 회전 바퀴와 가장 가까운 바퀴가 회전을 멈추면 더 왼쪽 바퀴들은 회전하지 X
				break;
			}
		}

		// 우
		for (int i = num; i <= 3; i++) {
			if (wheel[i][2] != wheel[i + 1][6]) {
				dir[i + 1] = -dir[i];
			} else { // 회전 바퀴와 가장 가까운 바퀴가 회전을 멈추면 더 오른쪽 바퀴들은 회전하지 X
				break;
			}
		}
	}
	
	// 2) 저장되어있는 회전 방향대로 각각 회전
	static void turn() {
		for (int i = 1; i <= 4; i++) { // 바퀴 번호
			if (dir[i] == 1) { // 시계 방향

				int tmp = wheel[i][7];

				for (int j = 7; j >= 1; j--) {
					wheel[i][j] = wheel[i][j - 1];
				}

				wheel[i][0] = tmp;

			} else if (dir[i] == -1) { // 반시계 방향

				int tmp = wheel[i][0];

				for (int j = 0; j <= 6; j++) {
					wheel[i][j] = wheel[i][j + 1];
				}

				wheel[i][7] = tmp;
			}
		}
	}

	// 3) 점수 합산
	static int getScore() {
		int score = 0;
		if (wheel[1][0] == 1)
			score += 1;
		if (wheel[2][0] == 1)
			score += 2;
		if (wheel[3][0] == 1)
			score += 4;
		if (wheel[4][0] == 1)
			score += 8;

		return score;
	}
}

	
	// 1번 : 2번 인덱스. 시계: 0번 반시계: 4번
	// 2번 : 6번 인덱스. 시계: 4번 반시계: 0번
//				2번 인덱스.   시계: 0번 반시계: 2번
	// 3번 : 6번 인덱스. 시계: 0번 반시계: 6번
//				2번 인덱스    시계: 0번, 반시계: 4번 
	// 4번 : 6번 인덱스 시계: 4번 반시계: 0번