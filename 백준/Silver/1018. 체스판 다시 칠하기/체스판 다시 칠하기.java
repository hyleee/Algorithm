import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] arr;
	static int min = 64;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			for(int m=0; m<M; m++) {
				if(str.charAt(m)=='W') {
					arr[n][m]=true;
				} else {
					arr[n][m]=false; 
				} 
			}
		}
		
		// 만들 수 있는 모든 8*8 정사각형에 대해
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				getMin(i,j);
			}
		}
		System.out.println(min);
	}
	
	static void getMin(int r, int c) {
		int cnt=0;
		
		boolean color = arr[r][c];
		
		for(int i=r; i<r+8; i++) {
			for(int j=c; j<c+8; j++) {
				if(arr[i][j]!=color) {
					cnt++;
				}
				color = !color; // 다음 칸으로 갈 때 원하는 색깔 change
			}
			color= !color; // 줄 바뀔 때
		}
		
		cnt = Math.min(cnt, 64-cnt); // 기준 2개 중 나머지 한 개로 하는 건 다시 계산할 필요 없이 64-cnt
		min = Math.min(cnt, min);
	}
}