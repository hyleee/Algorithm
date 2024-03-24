package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stone = new int[N];
		int[] dp = new int[N]; // 누적 최대 돌 개수 저장
		dp[0] =1;
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			stone[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int maxCnt=0;
			for(int j=0; j<i; j++) {
				if(stone[i]>stone[j]) {
					maxCnt = Math.max(maxCnt, dp[j]);
				}
			}
			dp[i] = maxCnt+1;
		}
		
		int ans=1;
		for(int n=0; n<N; n++) {
			ans = Math.max(ans, dp[n]);
		}
		
		
		System.out.println(ans);
		
	}
}
