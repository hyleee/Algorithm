import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr;
	static int N, K;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			cnt=0;
			getSum(0,0);
			
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
	
	static void getSum(int idx, int sum) {
		
		if(idx==N) {
			if(sum == K) {
				cnt++;
			}
			return;
		} 
		
		getSum(idx+1, sum);
		getSum(idx+1, sum+arr[idx]);
		
	}
}