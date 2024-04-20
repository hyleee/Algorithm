import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Short implements Comparable<Short> {
	int end, weight;

	public Short(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	// weight 기준 오름차순
	@Override
	public int compareTo(Short o) {
		return this.weight - o.weight;
	}
}

public class Main {

	static int V, E, K;
	static List<Short>[] shortList;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		shortList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			shortList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			shortList[start].add(new Short(end, weight));
		}
		
		StringBuilder sb = new StringBuilder();
		dijkstra(K);
		
		for(int i=1; i<=V; i++) {
			if(dist[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i]+"\n");
		}
		
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Short> q = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		q.add(new Short(start, 0));
		dist[start]=0;
		
		while(!q.isEmpty()) {
			Short curNode = q.poll();
			int curEnd = curNode.end; // 지금 출발지
			
			if(check[curEnd]) continue;
			check[curEnd]= true;
			
			for(Short node : shortList[curEnd]) { // 갈 수 있는 목적지 모두 탐색
				if(dist[node.end] > dist[curEnd] + node.weight) {
					dist[node.end] = dist[curEnd] + node.weight; // 최소 가중치 갱신
					q.add(new Short(node.end, dist[node.end]));
				}
			}
		}
	}
}