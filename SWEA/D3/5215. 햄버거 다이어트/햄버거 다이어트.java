import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int maxScore;
	static int N, L;
	static int[] score; 
	static int[] kcal;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 개수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			score = new int[N];
			kcal = new int[N];
			
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				score[n] = Integer.parseInt(st.nextToken()); // 재료 개수
				kcal[n] = Integer.parseInt(st.nextToken()); // 제한 칼로리
			}
			
			maxScore =0;
			cook(0, 0, 0);
			sb.append("#"+t+" "+maxScore+"\n");
		}
		System.out.println(sb);
	}
	

	// 재료 순서대로 하나씩 선택 하거나, 안하거나에 대해 모두 함수 실행
	static void cook(int idx, int sumScore, int sumKcal) {
		// 이미 idx 번째 재료는 지나왔고, idx+1 번째 재료 결정하기 전 작업을 함수 내에서 하는거
		
		// 1. 제한 칼로리 초과할 경우 종료
		if(sumKcal > L) return;
		// 2. 제한 칼로리 조건 만족할 경우 max 갱신
		else maxScore = Math.max(maxScore, sumScore);
		
		// 3. 주어진 재료 모두 봤을 때 종료 (이번 재료가 가장 마지막 재료일 때)
		if(idx==N) return;

		// idx 번째 재료를 선택할 경우
		cook(idx+1, sumScore+score[idx], sumKcal+kcal[idx]);
		// idx번째 재료를 선택하지 않을 경우
		cook(idx+1, sumScore, sumKcal);
	}
}