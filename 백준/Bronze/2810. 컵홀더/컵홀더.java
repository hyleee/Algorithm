

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		String seat = br.readLine();
		String str ="";
		
		for(int i=0; i<N; i++) {
			if(seat.charAt(i)=='S') {
				str+="*S";
			}
			else if(seat.charAt(i)=='L') {
				str+="*LL";
				// L 두개가 한꺼번에 주어지므로 index 한칸 더 건너뛰기
				i++;
			}
		}
		str+="*"; // 마지막 자리 컵홀더 추가
		
		int cnt=0;

		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='*') {
				cnt++;
			}
		}
		
		// 컵홀더가 사람보다 많을 수도 있다는 것을 주의
//		컵홀더 > 사람수 -> 사람 수 
//		사람수 > 컵홀더 -> 컵홀더 수
		System.out.println(Math.min(N, cnt));
		
	}
}
