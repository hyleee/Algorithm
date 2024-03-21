import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans=-1;
			int N = Integer.parseInt(br.readLine());
			arr= new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int n = 0; n < N; n++) {
				arr[n]= Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int num = arr[i] * arr[j];
					onlyUp(num);
				}				
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void onlyUp(int num) {
		boolean flag =true; // 단조증가인지 아닌지
		String str = Integer.toString(num);
		
		for(int i=0; i<str.length()-1; i++) {
			if((str.charAt(i)-'0')>(str.charAt(i+1)-'0')) {
				flag=false; // 단조증가가 아니다.
				break;
			}
		}
		
		if(flag) {
			ans = Math.max(num, ans);
		}
	}
}