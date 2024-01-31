import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int upCnt=1, downCnt=1;
		int max = 1;
		
		// 오름차순 카운트
		for(int i=0; i<N-1; i++) {
			if(arr[i+1]>=arr[i]) {
				upCnt++;
				if(upCnt>max) max = upCnt;
			} else {
				upCnt=1;
			}
		}
		
		// 내림차순 카운트
		for(int i=0; i<N-1; i++) {
			if(arr[i+1]<=arr[i]) {
				downCnt++;
				if(downCnt>max) max = downCnt;
			} else {
				downCnt=1;
			}
		}
		
		System.out.println(max);
	}
}