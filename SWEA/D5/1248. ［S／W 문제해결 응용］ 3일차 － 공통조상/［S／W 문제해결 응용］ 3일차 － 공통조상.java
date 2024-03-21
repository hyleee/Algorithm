import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node1248 { 
	int num;
	int parentNum; // 공통 조상 찾기 위해 필요
	Node1248 left; // 서브 트리 개수 세기 위해 필요
	Node1248 right; // 서브 트리 개수 세기 위해 필요
}

public class Solution {

//	output: 가장 가까운 공통 조상, 가장 가까운 공통 조상을 루트로 하는 서브 트리의 크기

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Node1248[] tree;
	static boolean[] visited;
	static int parent; // 공통 조상 정점 번호
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점 개수 V
			int E = Integer.parseInt(st.nextToken()); // 간선 개수 E
			int vNum1 = Integer.parseInt(st.nextToken()); // 정점 번호1
			int vNum2 = Integer.parseInt(st.nextToken()); // 정점 번호2

			visited = new boolean[V+1]; // 정점 방문 배열
			tree = new Node1248[V + 1]; // 노드의 배열로 이루어진 트리
			for (int v = 1; v <= V; v++)
				tree[v] = new Node1248(); // 트리 노드 생성

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int parentNum = Integer.parseInt(st.nextToken());
				int childNum = Integer.parseInt(st.nextToken());
				setTree(parentNum, childNum);
			}
			
			cnt=0;
			visitParent(vNum1);
			visitParent(vNum2);
			getCnt(tree[parent]);
			
			sb.append("#"+t+" "+parent+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
	
	// 트리 노드 부모-자식 관계에 맞게 연결
	static void setTree(int parentNum, int childNum) {
		tree[parentNum].num = parentNum;
		tree[childNum].num = childNum;
		tree[childNum].parentNum = tree[parentNum].num;
		
		if(tree[parentNum].left==null) tree[parentNum].left = tree[childNum]; // 자식이 없었다면
		else tree[parentNum].right = tree[childNum]; // 이미 자식이 하나 있었다면
	}
	
	// 부모 정점 방문 처리
	static void visitParent(int vNum) {
		 parent = tree[vNum].parentNum; // 부모 정점 번호 get
		 
		 if(visited[parent]==false) visited[parent] = true; // 부모 정점 방문 처리
		 else return; // 이미 방문했다면 (가장 빠른 공통 조상이라면) 탐색 멈추기
		 
		 if(parent!=1) visitParent(parent); // 루트 노드가 아니라면 부모의 부모 탐색
	}

	// 서브 트리 개수 카운트
	static void getCnt(Node1248 node) {
		cnt++;
		if(node.left != null) getCnt(node.left);
		if(node.right != null) getCnt(node.right);
	}
	
}