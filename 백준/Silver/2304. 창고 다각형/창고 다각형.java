import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 가장 큰 기둥을 중심으로 왼,오 로 향할수록 내려가기만 하도록

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int maxH = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, arr[n][1]);
		}

		// x좌표 기준 오름차순으로 정렬
		Arrays.sort(arr, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		// 가장 높이가 큰 기둥이 여러 개일 수도
		// 가장 큰 기둥 중 가장 왼쪽에 있는 기둥을 찾아 왼쪽 파트 검사 경계점으로

		int maxLeft = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i][1] == maxH)
				maxLeft = i;
		}

		int result = maxH;

		int L = arr[0][0];
		int H = arr[0][1];

		for (int i = 0; i <= maxLeft; i++) {
			if (arr[i][1] >= H) { // 이전 기둥보다 크거나 같으면
				result += (arr[i][0] - L) * H; // 넓이 갱신
				// update
				L = arr[i][0];
				H = arr[i][1];
			}
		}

		L = arr[N - 1][0];
		H = arr[N - 1][1];

		for (int i = N - 1; i >= maxLeft; i--) { // 거꾸로 검사
			if (arr[i][1] >= H) { // 이전 기둥보다 크거나 같으면
				result += (L - arr[i][0]) * H;
				L = arr[i][0];
				H = arr[i][1];
			}
		}
		System.out.println(result);
	}
}