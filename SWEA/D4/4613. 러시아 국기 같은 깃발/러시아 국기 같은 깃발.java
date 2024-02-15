import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] a = new char[n][m];
			int[] w = new int[n]; // 각 line 별 w 개수 저장
			int[] b = new int[n]; // 각 line 별 b 개수 저장
			int[] r = new int[n]; // 각 line 별 r 개수 저장
			
			int[] ws = new int[n - 2];
			int[] rs = new int[n - 2];
			
			for(int i = 0; i < n; i++) {
				String s = sc.next();
				int w_cnt = 0;
				int b_cnt = 0;
				int r_cnt = 0;
				for(int j = 0; j < m; j++) {
					a[i][j] = s.charAt(j);
					if(a[i][j] != 'W') w_cnt++;
					if(a[i][j] != 'B') b_cnt++;
					if(a[i][j] != 'R') r_cnt++;
				}
				w[i] = w_cnt;
				b[i] = b_cnt;
				r[i] = r_cnt;
			}
			ws[0] = w[0];
			rs[0] = r[n-1];
			
			for(int i = 1; i < n - 2; i++) {
				// 흰색 몇줄, 빨간 색 몇줄을 미리 저장한 후 그에 따라 파란색을 칠해야하는 수만 사이클마다 탐색
				ws[i] = ws[i - 1] + w[i];
				rs[i] = rs[i - 1] + r[n - 1 - i];
			}
			
			
			int result = n * m;
			for(int i = 0; i < n - 2; i++) {
				for(int j = 0; j < n - 2; j++) {
					int tmp = 0;
					tmp += ws[i];
					tmp += rs[j];
					for(int k = i + 1; k < n - j - 1; k++) {
						tmp += b[k];
					}
					result = Math.min(result, tmp);
				}
			}
			System.out.println("#" + t + " " + result);

			// 바꾸는게 적은 걸 세려고하지 말고, 유지시킬 수 있는게 많은 걸로 생각을 바꾸자

			// 첫줄은 다 W로
			// 마지막줄은 다 R로

			// W는 n=0 부터 n=N-3 까지 가능
			// B는 n=1 부터 n=N-2 까지 가능
			// R는 n=2 부터 n=N-1 까지 가능
		}
	}
}