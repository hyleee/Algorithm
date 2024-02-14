import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node1232{
	int num;
	String data;
	Node1232 left;
	Node1232 right;
	
	Node1232(){}
	
	Node1232(int num, String data){
		this.num = num;
		this.data = data;
		this.left  = null;
		this.right = null;
	}
}

// 정점이 정수 : 정점 번호, 양의 정수
// 정점이 연산자 : 정점 번호, 연산자, 해당 정점의 왼쪽 자식 정점 번호, 오른쪽 자식 정점 번호
public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException, ArithmeticException {
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			Node1232[] tree = new Node1232[N+1]; // 노드의 배열로 이루어진 트리
			
			// 트리 노드 생성
			for(int n=1; n<=N; n++) {
				tree[n] = new Node1232();
			}
			
			// 트리 설정
			for(int n=1; n<=N; n++) {
				st = new StringTokenizer(br.readLine());
				
				// 정수, 연산자 모두 num, data 저장
				tree[n].num = Integer.parseInt(st.nextToken());
				tree[n].data = st.nextToken();
				
				 if(st.hasMoreTokens()) { // 연산자라면 left, right도 저장
					 tree[n].left = tree[Integer.parseInt(st.nextToken())];
					 tree[n].right = tree[Integer.parseInt(st.nextToken())];
				 }
			}	
			sb.append("#"+t+" "+postorder(tree[1])+"\n");
		}
		System.out.println(sb);
	}
	
	// 연산자인지 아닌지
	static boolean isOperator(String str) {
		 if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) return true;
		 return false;
	}
	
	// 계산기
	static int calculator(int num1, int num2, String str) {
		if(str.equals("+")) return num1+num2;
		else if(str.equals("-")) return num1-num2;
		else if(str.equals("*")) return num1*num2;
		else if(str.equals("/")) return num1/num2;
		return -1;
	}
	
	// 후위 순회
	static int postorder(Node1232 node) { 

		if(isOperator(node.data)) { // 연산자라면
			int leftVal = postorder(node.left);
			int rightVal = postorder(node.right);
			return calculator(leftVal, rightVal, node.data);
		} else { // 숫자라면
			return Integer.parseInt(node.data);
		}
	}
}