import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	char data;
	Node left;
	Node right;
	
	Node(){
		this.left=null;
		this.right=null;
	}
}

// A, B, C, D ... 순서로 주어지는 게 아니란 걸 주의!
// 때문에 tree index를 for문 index랑 동일하게 하면 안되고,
// parentValue - 'A' 로 입력받는 tree index를 잡아주는게 맞다.
public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Node[] tree = new Node[N];
		
		for(int n=0; n<N; n++){
			tree[n] = new Node();
		}
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			char parentVal = st.nextToken().charAt(0);
			char leftVal = st.nextToken().charAt(0);
			char rightVal =  st.nextToken().charAt(0);
			
			tree[parentVal-'A'].data = parentVal;
			
			if(leftVal!='.') {
				tree[parentVal-'A'].left = tree[leftVal-'A']; // 연결
				tree[parentVal-'A'].left.data = leftVal; // 값 삽입
			}
			if(rightVal!='.') {
				tree[parentVal-'A'].right = tree[rightVal-'A']; // 연결
				tree[parentVal-'A'].right.data = rightVal; // 값 삽입
			}	
		}
		
		preorder(tree[0]);
		sb.append("\n");
		inorder(tree[0]);
		sb.append("\n");
		postorder(tree[0]);
		sb.append("\n");
		System.out.println(sb);
	}
	
	static void preorder(Node node) {
		if(node == null) return;
		
		sb.append(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	static void inorder(Node node) {
		if(node == null) return;
		
		inorder(node.left);
		sb.append(node.data);
		inorder(node.right);
	}
	
	static void postorder(Node node) {
		if(node == null) return;
		
		postorder(node.left);
		postorder(node.right);
		sb.append(node.data);
	}
}