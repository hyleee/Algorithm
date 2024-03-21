import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			int ans = check(str);
			if(str.charAt(0)=='0') ans= ans-1;
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);

	}

	static int check(String str) {
		int cnt = 1;
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				cnt++;
			}
		}
		return cnt;
	}
}

//010101 처음부터 연속적인 숫자가 나오는 패턴의 개수 
//첫 숫자가 0이면 -1
//첫 숫자가 1이면 그 개수 그대로