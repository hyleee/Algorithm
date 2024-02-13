import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] student = new int[2][6];
		int roomCnt =0;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			student[S][Y-1]++;
		}
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<6; j++) {
				roomCnt+=student[i][j]/K;
				if(student[i][j]%K!=0) {
					roomCnt++;
				}
			}
		}
		System.out.println(roomCnt);
	}
}