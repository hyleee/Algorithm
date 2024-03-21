import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node1231{
	int num;
	char data;
	Node1231 left;
	Node1231 right;
	
	Node1231(){}
	
	Node1231(int num, char data){
		this.num = num;
		this.data = data;
		this.left = null;
		this.right = null;
	}
}



// 해당 정점의 번호, 문자, 해당 정점의 왼쪽 자식 번호, 오른쪽 자식의 정점 번호 순서

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		for (int t = 1; t <= 10; t++) {

			int N = Integer.parseInt(br.readLine());
			Node1231[] tree = new Node1231[N+1]; // 노드의 배열로 이루어진 트리
//			int[] cnt = new int[N+1];  // 해당 노드가 타 노드의 자손일 때 ++
			
			for (int i = 1; i <= N; i++) {
                tree[i] = new Node1231();
//                tree[i].left = new Node1231();
//                tree[i].right = new Node1231();
            }
			
			
			for(int n=1; n<=N; n++) {
				st = new StringTokenizer(br.readLine());
				tree[n].num =  Integer.parseInt(st.nextToken());
				tree[n].data = st.nextToken().charAt(0);

				if(st.hasMoreTokens()) { // 자식이 1개 이상이라면
					tree[n].left = tree[Integer.parseInt(st.nextToken())];
				} 
				if(st.hasMoreTokens()) { // 자식이 2개라면
					tree[n].right = tree[Integer.parseInt(st.nextToken())];
				}
			}

//			int root = -1;
//			for(int i=1; i<=N; i++) {
//				if(cnt[i]==0) { // 한 번도 카운트된 적 없는 노드가 루트 노드
//					root = i;
//					break;
//				}
//			}
			
			sb.append("#"+t+" ");
			inorder(tree[1]);
			sb.append("\n");
		} //for (int t = 1; t <= 10; t++)
		System.out.println(sb);
	}
	
	static void inorder(Node1231 node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		sb.append(node.data);
		inorder(node.right);
	}	
}