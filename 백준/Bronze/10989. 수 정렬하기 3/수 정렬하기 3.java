import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n]; // 원본 배열
		
//		for(int i=0; i<n; i++) {
//			arr[i] = Integer.parseInt(br.readLine()); 
//		}
		
//		int[] cnt = new int[10000000]; // 이게 시간 초과의 원인!!!
		
		// 배열을 입력받는 동시에 max를 직접 찾은 후 cnt 길이로 지정하자.
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max)
				max = arr[i]; 
		}
		int[] cnt = new int[max+1]; // 
		
		// 개수 세기
		for(int i=0; i<n; i++) {
			cnt[arr[i]]++;
		}
		// 누적합 배열로 만들기 
		for(int i=1; i<cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		

		int[] sortedArr = new int[n]; // 정렬된 배열
		// 안정 정렬 때문에 뒤에서부터... 
		for(int j=arr.length-1; j>=0; j--) {
			// 배열에서 특정 인덱스 접근의 시간 복잡도는 O(1)
			// 배열의 모든 인덱스를 하나씩 접근하는 것의 시간 복잡도는 O(n)
			sortedArr[--cnt[arr[j]]] = arr[j];
		}
		
//		시스템 자원 소모때문에 느림 -> 1번만 써야함 !!!
//		for(int i=0; i<sortedArr.length; i++) {
//			System.out.println(sortedArr[i]);
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(sortedArr[i]).append('\n');
		}
		System.out.println(sb);
		
		
	}
}