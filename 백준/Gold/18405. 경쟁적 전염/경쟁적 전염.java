import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int r;
	int c;
	int virus;
	int time;

	public Node(int r, int c, int virus, int time) {
		super();
		this.r = r;
		this.c = c;
		this.virus = virus;
		this.time = time;
	}

}

public class Main {

	static final int[] dr = { 0, 0, -1, 1 };
	static final int[] dc = { -1, 1, 0, 0 };
	static int N, K, s, x, y;
	static int[][] map;
	static ArrayList<Node> list = new ArrayList<>();
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					list.add(new Node(i, j, map[i][j], 0));
				}
			}
		}

		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.virus - o2.virus;
			}
		});

		for (Node node : list) {
			q.add(node);
		}

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		
		bfs();
		System.out.println(map[x-1][y-1]);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			
			if(cur.time==s) {
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc= c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(map[nr][nc]==0) {
						map[nr][nc] = cur.virus;
						q.add(new Node(nr, nc, cur.virus, cur.time+1));
					}
				}
			}
		}
	}

}