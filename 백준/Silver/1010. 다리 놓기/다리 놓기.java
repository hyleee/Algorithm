import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			dp = new int[M+1][N+1];
			
			sb.append(comb(M,N)+"\n");
		}
		System.out.println(sb);
		
	}
	
	static int comb(int n, int k) { // n개 중 k개 조합
		if(dp[n][k] > 0 ) {
			return dp[n][k];
		}
		
		if(k==0 || n==k) {
			return dp[n][k]=1;
		}
		
		return dp[n][k] = comb(n-1,k-1) + comb(n-1,k);
	}
}