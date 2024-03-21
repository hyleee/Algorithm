import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 전제 조건
// 가장 윗 행부터 아래로 한 줄 씩, 행 1개당 퀸 1개씩 채워나가겠다.
// arr의 index는 각 퀸의 행 idx, arr의 값은 각 퀸의 열 idx

public class Main {

	static int N;
	static int[] arr;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



		N = Integer.parseInt(br.readLine());
		arr = new int[N]; // 해당 행의 queen이 있는 열(col)을 저장할 배열
		result = 0;

		putQueen(0); // 인자 : 지금까지 놓은 퀸의 수
        System.out.println(result);
	

	}

	static void putQueen(int qNum) {
		// 퀸 n개 모두 놓았으면 카운트 후 종료
		if (qNum == N) { 
			result++;
			return;
		}
		
		// 퀸을 아직 n개 놓지 않았다면 각 행의 각 열에 퀸을 놓아보며 가능한 위치 탐색
		for (int i = 0; i < N; i++) {
			arr[qNum] = i; // 현재 qNum행의 현재 i열(for문 내에서 갱신) 정보 저장
			if(isPossible(qNum)) putQueen(qNum + 1); //조건 만족시에만 다음 행 이동 후 퀸 배치

		}
	}

	static boolean isPossible(int qNum) {
		for(int i=0; i<qNum; i++) { // qNum보다 큰 행은 놓지를 않았으니까 검사할 필요X
			// 같은 열에 존재할 경우
			if(arr[i]==arr[qNum]) return false;
			// 대각선 상에 놓이는 경우 (열의 차 = 행의 차)
			if(Math.abs(qNum-i) == Math.abs(arr[qNum]-arr[i])) return false;
		}
		return true;
	}
}