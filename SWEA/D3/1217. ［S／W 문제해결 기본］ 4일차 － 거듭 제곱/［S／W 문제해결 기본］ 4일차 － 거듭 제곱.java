import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			sb.append("#"+t+" "+pow(makeInt(st), makeInt(st))+"\n");
		}
		System.out.println(sb);
	}
	
	static int makeInt(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
	
	static int pow(int n, int m) {
		
		if(m==1) {
			return n;
		}
		
		int tmp = pow(n, m/2);
		if(m%2==0) {
			return tmp*tmp;
		} else {
			return tmp*tmp*n;
		}
	}
}