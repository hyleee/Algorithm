import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] adj; // 간선 표시. 방향 존재.
	static int[] degree; // 진입 차수 저장
	static int V, E;
	static StringBuilder sb =  new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점 개수 
			E = Integer.parseInt(st.nextToken()); // 간선 개수
			
			adj= new int[V+1][V+1];
			degree =  new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int e=0; e<E; e++) {
				 int start = Integer.parseInt(st.nextToken());
				 int end = Integer.parseInt(st.nextToken());
				 
				 adj[start][end]=1;
				 degree[end]++;
			}
			
			topologicalSort();
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		
		// 1) 진입차수가 0인 정점 번호 삽입 
		for(int i=1; i<=V; i++) {
			if(degree[i]==0) q.offer(i);
		}
		
		// 2) 큐가 공백상태가 될 때까지 반복
		while(!q.isEmpty()) {
			// 2-1) 하나 꺼내기
			int cur = q.poll();
			sb.append(cur+" ");
			
			// 2-2) 꺼냈다는 표시로서,, 연결되어 있는 간선을 제거
			for(int i=0; i<=V; i++) {
				if(adj[cur][i]==1) {
					degree[i]--;
					// 2-3) 진입 차수가 새롭게 0이 되었다면 큐에 삽입
					if(degree[i]==0) q.offer(i);
					adj[cur][i] = 0;
				}
				
			}
		}
	}
}