import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, B;
	static int[] arr;
	static int minHeight;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			minHeight =Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken()); // 점원들 키의 합보다 작은 수 
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			getHeight(0, 0);
			sb.append("#"+t+" "+(minHeight-B)+"\n");
		}
		System.out.println(sb);
		
	}
	
	static void getHeight(int idx, int sum) {
		
		if(sum>=B) {
			minHeight = Math.min(minHeight, sum);
			return;
		}
		if(idx==N) return;
		
		getHeight(idx+1, sum + arr[idx]);
		getHeight(idx+1, sum);
	}
	
}