
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int[] mushroom = new int[10];
		
		for(int i=0; i<10; i++) {
			mushroom[i] = Integer.parseInt(br.readLine());
		}
		
		int answer=0;
		int sum=0;
		
		for(int i=0; i<10; i++) {
			
			sum+=mushroom[i];
			
			if(Math.abs(sum-100)<Math.abs(sum-mushroom[i]-100)){
				answer=sum;
			}
			else if(Math.abs(sum-100)==Math.abs(sum-mushroom[i]-100)){
				answer=sum;
			}
			
			
		}
		
		System.out.println(answer);
	}
}
