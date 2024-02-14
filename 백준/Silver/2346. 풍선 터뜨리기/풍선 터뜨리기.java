import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Balloon{
	int balNum;
	int moveNum;
	
	public Balloon(int balNum, int moveNum) {
		this.balNum = balNum; // 풍선 번호
		this.moveNum = moveNum; // 종이 안의 값
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Deque<Balloon> dq = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int n=0; n<N; n++) {
			int moveNum = Integer.parseInt(st.nextToken());
			dq.add(new Balloon(n+1, moveNum));
		}
		
		while(!dq.isEmpty()) {

			
			Balloon balloon = dq.pollFirst(); 
			int move = balloon.moveNum; 
			sb.append(balloon.balNum+" "); 
			
			if(dq.isEmpty()) break;
			
			if(move>0) { // 양수일 경우 인덱스가 큰 쪽의로
				// 1. 왼쪽(앞)에 남는 애들 뒤로 밀어버리기
				for(int i=1; i<move; i++) { // move 횟수보다 1만큼 적게 밀기
					dq.addLast(dq.pollFirst());
				}
			} else { // 음수일 경우 인덱스가 작은 쪽으로 
				// 2. 오른쪽(뒤)에 남는 애들 앞으로 밀어버리기
				for(int i=0; i< Math.abs(move); i++) { 
					// i=1 부터 시작했다가 틀렸음
					// 정확히 move 횟수만큼 해줘야 이번에 터뜨리고 싶은게 가장 왼쪽에 배치됨
					dq.addFirst(dq.pollLast());
				}
			}
		}
		System.out.println(sb);
	}
}