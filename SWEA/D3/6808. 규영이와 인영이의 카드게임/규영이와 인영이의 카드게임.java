import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int win, lose;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			 
			 win=0; lose=0;
			 
			 int[] card1 = new int[9]; // 규영이 카드 저장할 배열
			 boolean[] selected = new boolean[19]; // 사용된 카드 체크
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 for(int i=0; i<9; i++) {
				 card1[i]=Integer.parseInt(st.nextToken());
				 selected[card1[i]]=true;
			 }

			 int[] card2 = new int[9]; // 인영이 카드 저장할 배열
			 setSequence(card1, selected, card2, 0);
			 
			 sb.append("#"+t+" "+win+" "+lose+"\n");
		}
		System.out.println(sb);
	}
	
	
	// 인영이가 카드를 어케 낼지
	static void setSequence(int[] card1, boolean[] selected, int[] card2,  int idx) {
		if(idx ==9) {
			playGame(card1, card2);
			return;
		} 
		
		for(int i=1; i<=18; i++) {
			if(!selected[i]) {
				selected[i] = true;
				card2[idx]= i;
				setSequence(card1, selected, card2, idx+1);
				selected[i] = false;
			}		
		}
	}
	
	// 점수 계산
	static void playGame(int[] card1, int[] card2) {
		
		int score1=0, score2=0;
		for(int i=0; i<9; i++) {
			int num1 = card1[i];
			int num2 = card2[i];
			
			if(num1>num2) score1+= num1+num2;
			else score2+= num1+num2;
		}
		if(score1>score2) win++;
		else if(score1<score2) lose++; 
		
	}
}