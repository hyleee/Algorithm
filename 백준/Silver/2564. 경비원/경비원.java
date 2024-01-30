import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken()); 
		int col = Integer.parseInt(st.nextToken());
		int shop= Integer.parseInt(br.readLine());
		int total =0, police =0;
		
		map = new int[shop];
		
		for(int i=0; i<shop+1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			int tmp=0;
			
			
			switch(dir) { // (0,0) 기준 시계 방향으로 핀 직선
			case 1: // 북
				tmp = loc;
				break;
			case 2: // 남
				tmp = row+ col + row - loc;
				break;
			case 3: // 서
				tmp = row + col + row + col - loc;
				break;
			case 4: // 동
				tmp = row + loc;
				break;
			}
			
			if(i<shop) { // 상점이면
				map[i] = tmp;
			} else { // 동근이면
				police = tmp;
			}
		}
			
		for(int i=0; i<shop; i++) {
			int path1 = Math.abs(police - map[i]);
			int path2 = 2*row + 2*col - path1;
			total+=Math.min(path1, path2);
		}
		System.out.println(total);
		
	}
}