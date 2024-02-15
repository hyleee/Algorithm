import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 힙 정렬 오름차순
public class Main { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N/2-1; i>=0; i--) {
			heapify(N,i); // arr를 최대 힙으로
		}
		
		// 실제 배열의 정렬이 일어나는 구간
        // N-1번만 최댓값을 맨 마지막 값과 교환하면서 힙 크기를 줄여나가면 정렬이 완료됨
		for(int i=N-1; i>0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			
			// 루트 노드 삭제 후 가장 마지막 원소를 루트 자리에 두고 downheap 하는 과정
			heapify(i, 0); // heapSize자리에 들어가는 변수 i는 점점 감소 -> 힙 크기가 점점 감소 중
		}
		
		// (질문) 왜 최대 힙 생성시 i=N/2-1 부터인지
		// 완전 이진 트리에서 특정 노드 i의 왼쪽 자식은 2*i + 1, 오른쪽 자식은 2*i + 2
		// 자식 노드 중에서 가장 마지막 노드의 인덱스는 N - 1
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	
	// 힙 빌드
	private static void heapify(int heapSize, int parentIdx) {
		// 부모가 두 자식과 비교해가면서 자식 중에 더 큰게 있다면 자식 부모 swap
		int largest = parentIdx;
		int l = 2*parentIdx +1; //왼쪽 자식
		int r = 2*parentIdx +2; //오른쪽 자식
		
		if(l<heapSize && arr[l] > arr[largest]) largest = l;
		if(r<heapSize && arr[r] > arr[largest]) largest = r;
		if(largest != parentIdx) { // largest 갱신 여부 확인
			// largest번째 원소와 i번째 원소 교환
			int tmp = arr[parentIdx];
			arr[parentIdx] = arr[largest];
			arr[largest] = tmp;
			
			heapify(heapSize,largest); // 재귀 사용
		}
	}
	
}