import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int start;
	int end;
	int weight;
	
	public Edge(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
//		return weight - o.weight;
	}
}

public class Main {
	
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		edgeList = new ArrayList<>();
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(start, end, weight));
		}
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		edgeList.sort(null);
		
		
		int weigthSum =0;
		for(int i=0; i<edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			// 사이클이 발생하지 않는다면 (부모가 다르다면)
			if(find(edge.start)!=find(edge.end)) {
				weigthSum += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		System.out.println(weigthSum);
		
	}

	static int find(int x) {
		if(x!=parent[x]) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa!=pb) parent[pb] = pa;
	}

}