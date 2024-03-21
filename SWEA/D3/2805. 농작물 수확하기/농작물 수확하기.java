import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;
		String str;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}

			int ans = 0;
			int left = N / 2;
			int right = N / 2;
			
			for (int r = 0; r < N / 2; r++) {
				for (int c = left; c <=right ; c++) {
					ans += arr[r][c];
				}
				left--;
				right++;
			}

			for (int r = N / 2; r < N; r++) {
				for (int c = left; c <= right; c++) {
					ans += arr[r][c];
				}
				left++;
				right--;
			}
			
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}