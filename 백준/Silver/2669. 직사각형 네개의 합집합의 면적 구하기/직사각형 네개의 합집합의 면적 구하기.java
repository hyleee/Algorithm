import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		boolean[][] arr = new boolean[100][100];
//		Arrays.fill(arr, false);
		
		for(int i=0; i<4; i++) {
			st= new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=x1; j<x2; j++) {
				for(int k=y1; k<y2; k++) {
					arr[j][k] = true;
				}
			}
		}
		
		int area=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j]) area++;
			}
		}
		
		System.out.println(area);
		
	}
}