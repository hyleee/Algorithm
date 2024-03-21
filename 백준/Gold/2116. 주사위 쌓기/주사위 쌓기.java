import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int N;
	static int maxSum=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][6];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				arr[n][i] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 6; i++) { // 첫 주사위의 면 6개를 모두 밑면으로 각각 시도
			build(i, 1, 0); // cnt : 주사위 번호 
		}
		System.out.println(maxSum);

	}
	
	static void build(int downIdx, int cnt, int sum) { 
		
		
		int upIdx = pairCheck(downIdx); // 현재 주사위의 윗면 idx
		sum += getMax(downIdx, cnt); 

		if(N==cnt) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		
		
		for(int i=0; i<6; i++) {
			if(arr[cnt+1][i] == arr[cnt][upIdx]) {
				build(i, cnt+1, sum);
				break;
			}
		}	
	}

	static int pairCheck(int idx) {
		if (idx == 0)
			return 5;
		else if (idx == 1)
			return 3;
		else if (idx == 2)
			return 4;
		else if (idx == 3)
			return 1;
		else if (idx == 4)
			return 2;
		else
			return 0;
	}

	static int getMax(int downIdx, int cnt) {
		int max = 0;
		for (int i = 0; i < 6; i++) {
			if (i == pairCheck(downIdx))
				continue;
			if (i == downIdx)
				continue;
			// 마주보는 면이 아닐 때만
			max = Math.max(max, arr[cnt][i]);
		}
		return max;
	}
}

//A B C D E F
//0 1 2 3 4 5 
//마주보는 면: 
//A-F 0-5 
//B-D 1-3  
//C-E 2-4