
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		final int MAX_SIZE=101;
		int cnt=0;
		
		boolean[][] arr = new boolean[MAX_SIZE][MAX_SIZE];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			
			for(int j=x; j<(x+10>100?  101 : x+10); j++) {
				for(int k=y; k<(y+10>100? 101: y+10); k++) {
					if(!arr[j][k]) {
						arr[j][k]=true;
						cnt++;
					}	
				}
			}
		}
		
		System.out.println(cnt);	
	}
}
