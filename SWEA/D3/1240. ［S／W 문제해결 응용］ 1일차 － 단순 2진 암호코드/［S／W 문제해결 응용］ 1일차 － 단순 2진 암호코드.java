import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] code = { 13, 25, 19, 61, 35, 49, 47, 59, 55, 11 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }

			Queue<Integer> pw = new LinkedList<>(); // 56개 저장

			PW: for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 55; j--) {
					 if (arr[i].charAt(j) - '0' == 1) {
	                        for (int k = j - 55; k <= j; k++) {
	                            pw.add(arr[i].charAt(k) - '0');
	                        }
	                        break;
	                    }
				}
			}

			int[] pw2code = makeCode(pw);
			if (isPossible(pw2code)) {
				sb.append(getSum(pw2code) + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		System.out.println(sb);
	}

	static int[] makeCode(Queue<Integer> pw) {

		int[] codeNumbers = new int[8];

		for (int i = 0; i < 8; i++) {
			int codeNum = 0;
			for (int j = 6; j >= 0; j--) { // 앞에서부터면 큰 수부터 줄어들기
				codeNum += pw.poll() * pow(2, j);
			}
			for (int j = 0; j < 10; j++) {
				if (code[j] == codeNum) {
					codeNumbers[i] = j;
					break; // 해당 숫자를 찾았으면 더 이상 반복할 필요가 없으므로 break
				}
			}
		}
		return codeNumbers;
	}

	static boolean isPossible(int[] codeNumbers) {

		int sum = 0;
		for (int i = 0; i < codeNumbers.length; i++) {
			if (i % 2 == 0)
				sum += codeNumbers[i] * 3;
			else
				sum += codeNumbers[i];
		}

		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}

	static int getSum(int[] codeNumbers) {
		int sum = 0;
		for (int i = 0; i < codeNumbers.length; i++) {
			sum += codeNumbers[i];
		}
		return sum;
	}

	public static int pow(int n, int m) {
		if (m == 0) {
			return 1;
		}
		return n * pow(n, m - 1);
	}
}

//원래암호:00011010001101010111100110010111101011011100010110111011 
//입력암호:01110110110001011101101100010110001000110100100110111011