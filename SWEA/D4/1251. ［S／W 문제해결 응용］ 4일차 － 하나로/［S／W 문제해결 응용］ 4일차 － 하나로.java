import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 간선을 리스트로 저장
class Edge implements Comparable<Edge>{
	int from;
	int to;
	long weight;
	
	public Edge(int from, int to, long weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	// 가중치 기준 오름차순 정렬
	@Override
	public int compareTo(Edge edge) {
//		return (int) (this.weight - edge.weight);
		return Long.compare(this.weight, edge.weight);
	}
}

public class Solution {
	
	static int[] parent;
	static ArrayList<Edge> edgeList;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] island = new int[N][2];
			parent= new int[N];
			makeParent(N);
			
			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			
			for(int n=0; n<N; n++) {
				int x = Integer.parseInt(stX.nextToken());
				int y = Integer.parseInt(stY.nextToken());
				island[n][0] = x;
				island[n][1] = y;
			}
			
			double E = Double.parseDouble(br.readLine());
			
			
			// 간선 가중치 기준 오름차순 정렬
			makeEdgeList(island);
			edgeList.sort(null);
			makeParent(N);
			long weightSum = getWeightSum();

			sb.append("#"+t+" "+Math.round(weightSum*E)+"\n");
		}
		
		System.out.println(sb);
	}
	
	static long getWeightSum() {
		int edgeCnt =0; // 간선 개수 : 최대 N-1개 필요할거야.
		long weightSum =0; // 간선 가중치 저장
		
		for(Edge edge : edgeList) {
			// 사이클이 형성되지 않으면
			if(union(edge.from, edge.to)) {
				weightSum += edge.weight;
//				edgeCnt++;
				if(++edgeCnt == N-1) break;
			}
		}
		return weightSum;
	}
	
	static void makeEdgeList(int[][] island) {
		edgeList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				long dis = getDistance(island[i][0], island[i][1], island[j][0], island[j][1]);
				edgeList.add(new Edge(i,j,dis));
			}
		}
	}
	
	static long getDistance(int x1, int y1, int x2, int y2) {
		long xDis = Math.abs(x1-x2);
		long yDis = Math.abs(y1-y2);
		return xDis*xDis + yDis*yDis;
	}
	
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 사이클 형성 시
		if(aRoot == bRoot) return false;
		// 사이클 형성 안된다면 이어주자. 
		parent[bRoot] = aRoot;
		return true;
	}
	
	static int find(int a) {
		if(a!= parent[a]) parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void makeParent(int N) {
		for(int i=0; i<N; i++) {
			parent[i]=i;
		}
	}
}