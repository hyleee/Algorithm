import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	static char[] arr;
	static int N, K;
	static TreeSet<Integer> numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = br.readLine().toCharArray();
			numbers= new TreeSet<>();
			
			getNum();
			for (int i = 0; i < N / 4 -1; i++) { // 각 회전마다 처리. N/4번 회전해야 모든 경우를 볼 수 있다.
				rotate();
				getNum();
			}
			
			int ans = -1;
			for(int i=0; i<K; i++) {
				ans =  numbers.pollLast();
//				System.out.println("poll: "+ans);
			}
			
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	// 알맞은 길이만큼 잘라서 TreeSet에 삽입하기
	static void getNum() {
		// 한 변 당 숫자 길이
		int len = N/4;
		
		for(int i=0; i<N; i+=len) { // 네 변에 대해
			String str = ""; //i번째부터 i*N/4까지
			for(int j=0; j<len; j++) {
				str += arr[i+j];
			}
			int strToNum = Integer.parseInt(str, 16);// 16진수를 10진수로 변환
//			System.out.println(strToNum);
			numbers.add(strToNum);
		}
		
	}
	
	
	// 회전
	static void rotate() {
		char tmp = arr[N-1]; // 마지막 원소
		for(int i=N-1; i>0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = tmp;
	}

}