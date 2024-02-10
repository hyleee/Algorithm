import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			long x =  Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.isEmpty()) { // 비어있으면
					sb.append(0+"\n");
				} else { // 비어있지 않으면
					sb.append(pq.poll()+"\n");
				}
			}else { // 자연수
				pq.add(x);
			}
		}
		System.out.println(sb);
	}
}