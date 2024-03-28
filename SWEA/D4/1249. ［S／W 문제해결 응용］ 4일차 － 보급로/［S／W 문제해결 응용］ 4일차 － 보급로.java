

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


class Node implements Comparable<Node>{
	
	int r;
	int c;
	int cost;
	
	public Node(int r, int c, int cost) {
		super();
		this.r = r;
		this.c = c;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node node) {
		return Integer.compare(this.cost, node.cost);
	}

}

public class Solution {
	
	static int[] dr= {-1, 1, 0,0};
	static int[] dc= {0,0,-1,1};
	static int minTime;
	static int[][] dist;
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T= Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist= new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j)-'0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			prim();
			sb.append("#"+t+" "+dist[N-1][N-1]+"\n");

		}
		System.out.println(sb);
		
	}
	
	static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[0][0] =0; //(0,0)에서 출발
		visited[0][0]= true;
		pq.offer(new Node(0,0,0));
		
//		int timeSum=0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(isPossible(nr, nc) && !visited[nr][nc]) {
					if(dist[nr][nc] > dist[cur.r][cur.c] + map[nr][nc]) {
						dist[nr][nc] = dist[cur.r][cur.c] + map[nr][nc];
						pq.offer(new Node(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
	}
	
	static boolean isPossible(int nr, int nc) {
		if(nr<0 || nc<0 || nr>=N || nc>=N) return false;
		return true;
	}
}
