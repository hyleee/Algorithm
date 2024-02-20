import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int num;
	ArrayList<Node> adjacent;
		
	public Node(int num) {
		this.num=num;
		this.adjacent = new ArrayList<Node>();
	}
}

// 항상 부모-자식 순으로 주어지는 게 아니란 것을 주의
// 따라서 단순히 class 멤버 변수로 parent, child 를 선언할 것이 아니라
// 인접 노드를 저장할 리스트를 선언 후 BFS를 이용
public class Main {
	static int N;
	static Node[] tree;
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		
		for(int n=1; n<=N; n++) {
			tree[n] = new Node(n);
		}
		
		for(int n=1; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int num1 =  Integer.parseInt(st.nextToken());
			int num2 =  Integer.parseInt(st.nextToken());
			
			tree[num1].adjacent.add(tree[num2]);
			tree[num2].adjacent.add(tree[num1]);
		}
		
		getParent();
		
		for(int i=2; i<=N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void getParent() {
		parent = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(tree[1]);
		
		while(!q.isEmpty()) { // 먼저 방문하게 되는게 부모 (1이 루트노드니까)
			Node node = q.poll();
			visited[node.num] = true; // 방문 처리
			for(Node adNode : node.adjacent) {
				if(!(visited[adNode.num])) { // 인접 노드 방문하지 않았다면
					q.add(adNode); 
					parent[adNode.num] = node.num; // 자식 노드 번호에 부모 노드 저장
				}
			}
		}
	}
}