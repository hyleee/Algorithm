import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String str = br.readLine();
			int[] arr = new int[str.length()];
			int[] sumArr = new int[str.length()];
			int person =0;
			
			// 저장
			for(int i=0; i<str.length(); i++) {
				arr[i] = str.charAt(i)-'0';
				if(i==0) sumArr[i] = arr[i];
				else sumArr[i] = arr[i] + sumArr[i-1];
			}
//			System.out.println(Arrays.toString(sumArr));
			// 비교
			for(int i=0; i<str.length(); i++) {
				if(sumArr[i] <i+1) {
					person = Math.max(person, i+1-sumArr[i]);
				}
			}
			sb.append("#"+t+" "+person+"\n");
		}
		System.out.println(sb);
	}
}