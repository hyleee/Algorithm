import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String postfix = ""; // 후위 표기식
		Stack<Character> op = new Stack<>();
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);
		priority.put(')', 0);

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('A' <= c && c <= 'Z') {
				// 피연산자는 후위 표기식에 바로 출력
				postfix += c;
			} else if (c == '(') {
				op.push(c);
			} else if (c == ')') {
				while (!op.isEmpty() && op.peek() != '(') {
					// 여는 괄호 나올 때까지 후위 표현식으로 옮겨
					postfix += op.pop();
				}
				op.pop(); // 여는 괄호 버리기
			} else {
				// +, -, *, /
				if (op.isEmpty()) { // stack이 비어있으면 우선순위 비교할 필요X
					op.push(c);
				} else {
					// +, -, *, /
					// 우선 순위가 낮은 연산자가 마지막에 위치할 때까지 pop
					while (!op.isEmpty() && priority.get(c) <= priority.get(op.peek())) {
						// stack이 비어있지 않고, 이번 연산자의 우선순위가 top 연산자보다 높을 때까지
						postfix += op.pop();
					} // 조건을 만족해서 탈출했을 때 push
					op.push(c);
				}
			}
		} // for(int i=0; i<str.length(); i++)
		while (!op.isEmpty()) {
			postfix += op.pop();
		}
		System.out.println(postfix);
	}

}