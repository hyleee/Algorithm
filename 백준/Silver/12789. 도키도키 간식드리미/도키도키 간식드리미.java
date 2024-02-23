import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int okNum =1; // 현재 간식을 받을 사람의 번호
		for(int n=0; n<N; n++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		while(!(q.isEmpty())) { // 해당 whlie문 안에서 stack, q 동시 처리
			int curNum = q.peek();
			if(curNum==okNum) {
				okNum++;
				q.poll();
			} else if(!(stack.isEmpty()) && stack.peek()==okNum) {
				stack.pop();
				okNum++;
			} else {
//				stack이 비지는않앗는데 okNum이 아니다 
//				stack이 비었다
//				q가 비지는 않았는데 curNum != okNum
				stack.push(q.poll());
			}
		}
		// q가 비었으면 여기 올 수 있음
		// stack에 남아있을 수 있는 원소들 확인
		while(!(stack.isEmpty())){
			if(stack.peek()==okNum) {
				stack.pop();
				okNum++;
			} 
			else break;
		}
		
		if(okNum==N+1) System.out.println("Nice");
		else System.out.println("Sad");
		
	}
}