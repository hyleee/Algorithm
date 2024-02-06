import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
//		시간 초과
//		int[][] arr = new int[h][w];
//		
//		int[] dy = {1,1,-1,1};
//		int[] dx = {1, -1, -1, -1};
//		
//		int dir =0;
//		int ny=0, nx=0;
//	
//		for(int t=0; t<T; t++) {
//			
//			ny = y +dy[dir];
//			nx = x +dx[dir];
//			
//			if(ny<0 || ny>h || nx<0 || nx>w) {
//				dir= (dir++) %4;
//				ny = y +dy[dir];
//				nx = x +dx[dir];
//			}
//			
//			y = ny;
//			x = nx;
//		}
		
		int xCnt = (x+t)/w; // t초동안 x기준 W를 몇 번 움직였는지
		int yCnt = (y+t)/h; // t초동안 y기준 W를 몇 번 움직였는지
		int p,q;
		
		// x좌표
		if(xCnt%2==0) { // 왼 -> 오 하던 중에 멈춘다.
			p = (x+t) % w;
		} else { // 오 -> 왼 하던 중에 멈춘다.
			p = w - ((x+t)%w);
		}
		
		// y좌표
		if(yCnt%2==0) { // 위로 가던 중에 멈춘다.
			q =(y+t)%h;
		} else { // 아래로 가던 중에 멈춘다.
			q =h-((y+t)%h);
		}
		
		sb.append(p).append(" ").append(q);
		System.out.println(sb);
	}
}

//https://hanstemcell.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EA%B0%9C%EB%AF%B8?category=672485