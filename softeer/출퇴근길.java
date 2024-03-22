package softeer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 출퇴근길{

	static int N, M, S, T;
	static List<Integer>[] graph, reverseGraph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		graph = new ArrayList[N+1]; // 1-based
		reverseGraph = new ArrayList[N+1];
		
		
		// 점 개수만큼 출발점 세팅
		for(int n=0; n<=N; n++) { // 1-based
			graph[n] = new ArrayList<>();
			reverseGraph[n] = new ArrayList<>();
		}

		// 가능한 방향 저장
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			graph[i].add(j);
			reverseGraph[j].add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		// (1) 정방향
		// S->정점: S에서 시작해 T로 가는 경로에 포함된 정점 탐색
		boolean[] fromS = new boolean[N+1];
		fromS[T]=true;
		dfs(S, graph, fromS);
		
		// T->정점: T에서 출발해 S로 가는 경로에 포함된 정점 탐색 
		boolean[] fromT = new boolean[N+1];
		fromT[S] =true;
		
		dfs(T, graph, fromT);
		
		// (2) 역방향
		// 정점->T: S에서 시작해 T로 가는 경로의 역방향에 포함된 정점 탐색
		// 모든 정점에 대해 일일이 할 수 없으니까 S에서부터 시작하는거. 
		boolean[] toS = new boolean[N+1];
		dfs(S, reverseGraph, toS);
		
		// 정점->S: T에서 시작해 S로 가는 경로의 역방향에 포함된 정점 탐색 
		// 모든 정점에 대해 일일이 할 수 없으니까 T에서부터 시작하는거.
		boolean[] toT = new boolean[N+1];
		dfs(T, reverseGraph, toT);
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(fromS[i] && fromT[i] && toS[i] && toT[i]) cnt++;
		}
		
		System.out.println(cnt-2);
		
	}
	
	static void dfs(int now, List<Integer>[] adj, boolean[] visit) {
		if(visit[now]) return;
		visit[now]=true;
		for(int x : adj[now]) dfs(x, adj, visit);
	}
	
}