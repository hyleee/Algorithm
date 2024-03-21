import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N+1];
		
		int curIdx=1;
		int cnt=0;
		
		while(true) {
			
			arr[curIdx]++;
			if(arr[curIdx]>=M) {
				break;
			}
			if(arr[curIdx]%2==1) {
				if((curIdx+L)>=N) {
					curIdx += L-N;
				}
				else {
					curIdx+=L;
				}
			}
			else{
				if((curIdx-L)<0) {
					curIdx += -L+N;
				}
				else {
					curIdx += -L;
				}
			}
			cnt++;
		}
		System.out.println(cnt);	
	}
}