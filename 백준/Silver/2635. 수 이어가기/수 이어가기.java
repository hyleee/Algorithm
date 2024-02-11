

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<Integer> num = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		int maxLen =0;
		
//		100 절반보다 작은 값 절반보다 큰 값 음수
//		100 절반보다 큰 값 절반보다 작은 값 양수
//		100 절반 절반 0 절반 
//		적어도 N/2 이상은 되는 수부터 시작
		
//		1. 두 번째 수가 될 수 있는 후보에 대해 반복
		for(int i=N/2; i<=N; i++) {
			num.add(N);
			num.add(i);
			int idx = 2;
			
			// 2. 삽입 처리
			while(true) {
				int nextNum = num.get(idx-2) - num.get(idx-1);
				if(nextNum<0) break;
				else {
					num.add(nextNum);
					idx++;
				}
			}
			
			// 3. max 갱신 후 초기화
			if(maxLen<num.size()) {
				ans.clear(); 
				maxLen = num.size();
				ans.addAll(num);
			}
			
			// 4. 숫자들 담을 배열 초기화 (항상)
			num.clear();
		}
		
		// 5. 출력
		sb.append(maxLen+"\n");
		for(int i=0; i<ans.size(); i++) {
			sb.append(ans.get(i)+" ");
		}
		System.out.println(sb);
		
	}
}
