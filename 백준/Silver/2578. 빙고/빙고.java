import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[5][5];
	static int bingo=0;
	static int num=1; 
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		// 입력받기
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} //for(int i=0; i<5; i++)
		
			for(int i=0; i<5; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<5; j++) { // 사회자가 부를 숫자에 대한 for문
				int n = Integer.parseInt(st.nextToken());
				
				for(int k=0; k<5; k++) {
					for(int l=0; l<5; l++) {
						if(arr[k][l] == n) {
							arr[k][l]=0;
						}
					} 
				}
				
				col();
				row();
				leftToRight();
				rightToLeft();
				
				// 3줄 빙고일 경우
				if(bingo>=3) {
					System.out.println(num); // 사회자가 부른 숫자 개수 출력
					return;
				}
				
				// 3줄 빙고가 아니므로 새로운 턴을 돌아야 함
				bingo=0; // 빙고 수 초기화
				num++; // 사회자가 부른 숫자 개수 증가
			}// for(int j=0; j<5; j++) 
		} //for(int i=0; i<5; i++)	
	}
	
	// 가로 체크
	public static void col() {
		for(int i=0; i<5; i++) {
			int cnt=0;
			for(int j=0; j<5; j++) {
				if(arr[i][j]==0) {
					cnt++;
				}
				if(cnt==5) {
					bingo++;
				}
			}
		}
	}
	
	// 세로 체크
	public static void row() {
		for(int i=0; i<5; i++) {
			int cnt=0;
			for(int j=0; j<5; j++) {
				if(arr[j][i]==0) {
					cnt++;
				}
				if(cnt==5) {
					bingo++;
				}
			}
		}
	}
	
	// 대각선 체크 1
	public static void leftToRight() {
		int cnt=0;
		for(int i=0; i<5; i++) {
			if(arr[i][i]==0) {
				cnt++;
			}
			if(cnt==5) {
				bingo++;
			}
		}
	}
	
	// 대각선 체크 2
	public static void rightToLeft() {
		int cnt=0;
		for(int i=0; i<5; i++) {
			if(arr[i][4-i]==0) {
				cnt++;
			}
			if(cnt==5) {
				bingo++;
			}
		}
	}
	
}