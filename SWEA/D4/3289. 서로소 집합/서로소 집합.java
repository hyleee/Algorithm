

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			makeSet();
			
			StringBuilder sb = new StringBuilder();
	        sb.append('#').append(t).append(' ');

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int flag = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				int pa = find(a);
				int pb = find(b);

				if (flag == 0) { // 합집합
					if (pa != pb) {
						union(pa, pb);
					}
				} else if (flag == 1) // 같은 집합인지 확인
					if (pa == pb) { // 같은 집합
						sb.append(1);
					} else { // 다른 집합
						sb.append(0);
					}
			}
			 System.out.println(sb.toString());
		}
//		System.out.println(sb);
	}

	

	static void union(int a, int b) {
		// 각 집합을 대표하는 부모가 다른 부모로 편입되어야 한다.
		// 원소가 편입되어서는 안된다.!!!

//		int aRoot = find(a);
//		int bRoot = find(b);
//		if(a>b) parent[aRoot] = bRoot;
//		else parent[bRoot] = aRoot;

		parent[b] = a;

	}

	static void makeSet() {
		// 각 인덱스에 번호가 대응되도록 사이즈를 1 더해서 배열 선언
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int find(int x) {
		// 만일 찾는 대상과 인덱스 번호가 같다면 그 인덱스(=노드)가 해당 집합의 부모이다.
		if (parent[x] != x)
			parent[x] =find(parent[x]);
		// 그렇지 않다면, 해당 인덱스가 기리키는 값 (부모 노드)을 따라 최종 부모노드까지 탐색
		return parent[x];
	}
}



