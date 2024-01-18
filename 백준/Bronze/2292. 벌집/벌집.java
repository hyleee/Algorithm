
import java.util.Scanner;

public class Main {
//	2,3,4,5,6,7 (6개)-> 2
//	8,9,10,11,12,13,14,15,16,17,18,19 (12개)-> 3
//	20 부터 37 (18개)-> 4
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		
		int blank=1; // 몇 겹이냐
		int cnt=1; // 해당 껍질에 몇 칸이냐
		
		while(blank<n) {
			blank += cnt*6;
			cnt+=1;
		}
		System.out.println(cnt);
	}
}
