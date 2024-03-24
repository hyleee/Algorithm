import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS (Longest Increasing subsequence)

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N]; // 가장 긴 증가하는 부분 수열의 길이
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int max=0;
			for(int j=0; j<i; j++) {
				if(arr[j] <arr[i]) {
					max = Math.max(max, dp[j]);					
				}
			}
			dp[i] = max+1;
		}
		
		int ans=1;
		for(int n=0; n<N; n++) {
			ans = Math.max(ans, dp[n]);
		}
		
		System.out.println(ans);
	}
}