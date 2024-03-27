import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람 명 수
			int M = Integer.parseInt(st.nextToken()); // 조건 개수
			parent = makeSet(N);
			
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			Set<Integer> set = new HashSet<>();
			for(int n=1; n<=N; n++) {
				set.add(findSet(n));
			}
			
			sb.append(set.size()+"\n");
		}
		
		System.out.println(sb);
	}
	
	static int[] makeSet(int n) {
		int[] arr = new int[n+1];
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA  != rootB) parent[rootB] = rootA;
	}
	
	static int findSet(int x) {
		if(parent[x]!=x) parent[x] = findSet(parent[x]);
		return parent[x];
	}
}