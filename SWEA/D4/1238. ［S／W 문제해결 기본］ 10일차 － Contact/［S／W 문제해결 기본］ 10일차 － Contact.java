import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 내가 틀렸던 이유
// 1) while 문 안에서 qSize에 따른 for문을 수행하지 않았기 때문
// 같은 레벨에서 반복해 레벨 별 최댓값을 찾아야 한다.
// 각각의 연락 과정은 동시간대에 이루어지므로,,
// 2) 최종 maxNum과 levelMax를 따로 관리해야
// 정확히 마지막에 해당하는 레벨 내의 levelMax가 maxNum에 남게된다. 

public class Solution {

	static boolean[] visited;
	static int[][] adj;
	static int maxNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {

			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			// static 변수 초기화
			visited = new boolean[101];
			adj = new int[101][101];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
			}

			call(start);
			sb.append("#"+t+" "+maxNum+"\n");

		}
		System.out.println(sb);
	}

	static void call(int start) {

		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		maxNum = start; // 시작점으로 초기화

		while (!q.isEmpty()) {
			int levelMax =0;
			int qSize = q.size();
			
			// 동시간대 연락을 동시에 처리
			for(int s=0; s<qSize; s++) {
				int cur = q.poll();
				for (int i = 0; i < 101; i++) {
					if (adj[cur][i] == 1 && !visited[i]) { // 진행 가능하다면
						visited[i] = true; // 방문처리
						levelMax = Math.max(levelMax, i);
						q.offer(i);
					}
				}
			}
			if(levelMax>0) maxNum = levelMax;
		}
	}
}