import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Special implements Comparable<Special> {
	int end;
	int weight;

	public Special(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Special o) {
		return this.weight - o.weight;
	}
}

public class Main {

	static int N, E, V1, V2;
	static List<Special>[] specialList;
	static boolean[] check;
	static int[] dist; // 해당 정점까지의 최소 소요 거리 저장하는 배열
	static final int INF = 200000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수

		specialList = new ArrayList[N + 1];
		for (int n = 0; n <= N; n++) {
			specialList[n] = new ArrayList<>();
		}
		dist = new int[N + 1];
		check = new boolean[N + 1];

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			specialList[a].add(new Special(b, c));
			specialList[b].add(new Special(a, c));
		}

		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());

		// 1) 1 -> V1 -> V2 -> N
		int minDis1 = 0;
		minDis1 += dijkstra(1, V1);
		minDis1 += dijkstra(V1, V2);
		minDis1 += dijkstra(V2, N);

		// 2) 1 -> V2 -> V1 -> N
		int minDis2 = 0;
		minDis2 += dijkstra(1, V2);
		minDis2 += dijkstra(V2, V1);
		minDis2 += dijkstra(V1, N);

		int ans = (minDis1 >= INF && minDis2 >= INF) ? -1 : Math.min(minDis1, minDis2);
		System.out.println(ans + "\n");
	}

	private static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);

		PriorityQueue<Special> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		pq.offer(new Special(start, 0)); 
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Special curNode = pq.poll();
			int cur = curNode.end; // 현재 출발지
			
			if(!check[cur]) { // 현재 출발지를 아직 방문하지 않았다면
				check[cur] = true; // 방문 처리
				
				for(Special node : specialList[cur]) { // 모든 다음 간선 후보에 대해
					if(!check[node.end] &&  dist[node.end] > dist[cur] + node.weight ) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Special(node.end, dist[node.end]));
					}
				}
			}
		}
		return dist[end];
	}
}