import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			sb.append(isPalindrome(str, 0, 0, str.length()-1));
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int isPalindrome(String str, int res, int left, int right) {
		if(res==2) return 2;
		
		while(left<=right) {
			if(str.charAt(left)==str.charAt(right)) {
				left++;
				right--;
			} else {
				int deleteLeft = isPalindrome(str, res+1, left+1, right);
				int deleteRight = isPalindrome(str, res+1, left, right-1);
				res = Math.min(deleteLeft, deleteRight);
				break;
			}
		}
		return res;
	}
}