import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N =Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long answer = 0;

			int[] max = new int[N]; // 거꾸로 탐색하면서 지금까지의 최댓값 저장
			max[N - 1] = arr[N - 1]; 

			for (int i = N - 2; i >= 0; i--) {
				if (arr[i] > max[i + 1]) {
					max[i] = arr[i];
				} else {
					max[i] = max[i + 1];
				}

				answer += max[i] - arr[i];
			}

			System.out.println("#" + test_case + " " + answer);

		}

	}

}