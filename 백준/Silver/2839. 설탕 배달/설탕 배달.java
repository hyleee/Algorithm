import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int result=0;
		
		while(n>0) {
			if(n%5==0) { // 5의 배수이면
				result += n/5;
				System.out.println(result);
				return;
			}
			if(n<3) {
				System.out.println(-1);
				return;
			} // 3을 빼면 5로 나뉘어지는지 계속 돌면서 체크
			n-=3;
			result++;
		}
		
		System.out.println(result);
	}
}