import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] cal = new int[4]; // +,-,*,/ 개수 저장
	static int[] num;
	static int N;
	static int minNum;
	static int maxNum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cal[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				num[n] = Integer.parseInt(st.nextToken());
			}
			minNum = Integer.MAX_VALUE;
			maxNum = Integer.MIN_VALUE;
			calculator(num[0], 1, cal[0], cal[1], cal[2], cal[3]);
			int ans = maxNum - minNum;

			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	// 각각 남은 연산 횟수
	static void calculator(int result, int numIdx, int sum, int minus, int multi, int divide) {

		if (numIdx == N) {
			if (result > maxNum)
				maxNum = result;
			if (result < minNum)
				minNum = result;
			return;
		}

		if (sum > 0) {
			calculator(result + num[numIdx], numIdx + 1, sum - 1, minus, multi, divide);
		}
		if (minus > 0) {
			calculator(result - num[numIdx], numIdx + 1, sum, minus - 1, multi, divide);
		}
		if (multi > 0) {
			calculator(result * num[numIdx], numIdx + 1, sum, minus, multi - 1, divide);
		}
		if (divide > 0) {
			calculator(result / num[numIdx], numIdx + 1, sum, minus, multi, divide - 1);
		}
	}
}