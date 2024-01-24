
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		final int MAX =102;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		boolean[][] arr = new boolean[MAX][MAX];
		
		// 검은색 한 칸 중심으로 상하좌우 검사 시 하얀 부분 있으면 cnt
		int[] dx = { -1,1,0,0};
		int[] dy = {0,0, -1,1};
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 검은 부분은 모두 true로 
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					 arr[j][k]=true;
				}
			}
		}
		
		int result =0;
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(arr[i][j]) {
					int w=0;
					 for(int k=0; k<4; k++) {
						 int nx = i+dx[k];
						 int ny = j+dy[k];
						
						 if( arr[nx][ny]==false) {
							 w++;
						 }
					 }
					 if (w>=1) {
						 result += w;
					 }
				}
			}
		}
		System.out.println(result);
	}
}