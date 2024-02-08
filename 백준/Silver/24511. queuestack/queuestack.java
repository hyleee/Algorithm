import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stA, stB, stNum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine()); // 자료구조 개수
		stA = new StringTokenizer(br.readLine()); // 자료구조 타입
		stB = new StringTokenizer(br.readLine()); // 자료구조 내에 들어가있는 값
	
		Deque<Integer> dq = new ArrayDeque<>(); // queue만 저장
	
		for(int i=0; i<N; i++) {
			int type = Integer.parseInt(stA.nextToken());
			if(type==1) { // 스택이면
				stB.nextToken(); // 저장하진 않고 넘어가
			} else { //큐이면
				dq.addLast(Integer.parseInt(stB.nextToken()));
			}
		}

		// 삽입할 수열의 길이 M
		int M = Integer.parseInt(br.readLine());
		stNum = new StringTokenizer(br.readLine());
		
		for (int m = 0; m < M; m++) {
			
			dq.addFirst(Integer.parseInt(stNum.nextToken()));
			int res =dq.pollLast();
			sb.append(res+" ");
		}

		System.out.println(sb);
	}
}