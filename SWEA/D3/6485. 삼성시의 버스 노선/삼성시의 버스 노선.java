import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			int N = Integer.parseInt(br.readLine());
			int[] checkNum = new int[5001];

			for(int n=0; n<N; n++) { // n번 버스의 시작,끝 정류장
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				for(int i= start; i<=end; i++) {
					checkNum[i]++;
				}
			}

			int P = Integer.parseInt(br.readLine());
			for(int p=0; p<P; p++) {
				int idx = Integer.parseInt(br.readLine());
				sb.append(checkNum[idx]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);	
	}
}