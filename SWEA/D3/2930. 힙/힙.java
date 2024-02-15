import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	// 내림차순: 최댓값이 가장 먼저 pop됨
//	static PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
//		@Override
//		public int compare(Integer a, Integer b) {
//			return b - a;
//		}
//	});
	static PriorityQueue<Integer> heap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			heap = new PriorityQueue<>(Collections.reverseOrder());
			sb.append("#" + t + " ");
			int N = Integer.parseInt(br.readLine());

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				if (op == 1) { // 최대 힙에 추가하는 연산
					heapPush(Integer.parseInt(st.nextToken()));
//					System.out.println(heap.toString());
				} else { // 최대 힙 루트 노드 키 값 출력 후 해당 노드 삭제
					sb.append(heapPop() + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 삽입
	static void heapPush(int data) {
		heap.add(data);
	}

	// 삭제
	static int heapPop() {
		// 힙에 원소가 없다면
		if (heap.isEmpty()) return -1;

		// 루트에 있는 원소 제거
		int popItem = heap.poll();
		return popItem;
	}
}