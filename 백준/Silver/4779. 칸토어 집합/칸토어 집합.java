import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			
			int N = Integer.parseInt(str);
			sb = new StringBuilder();
			
			int len = (int) Math.pow(3,N);
			
			for(int i=0; i<len; i++) {
				sb.append("-"); 
			}
			
			func(0, len);
			System.out.println(sb);
		}
	}
	
	static void func(int startIdx, int len) {
		
		// base
		if(len==1) return;
		
		// recursive
		int newLen = len/3; // 한 마디 길이
		
		for(int i=startIdx+newLen; i<startIdx+newLen*2; i++) {
			sb.setCharAt(i, ' ');
		}
		
		func(startIdx, newLen);
		func(startIdx+2*newLen, newLen);
	}

}