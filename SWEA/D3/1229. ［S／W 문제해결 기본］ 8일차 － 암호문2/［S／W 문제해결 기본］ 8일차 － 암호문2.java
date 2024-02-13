import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int data;
	Node link; 
	
	Node(){}
	
	Node(int data){
		this.data = data;
		this.link = null;
	}
}

class SinglyLinkedList{
	Node head;
	int size;
	
	public SinglyLinkedList() {
		head = new Node();
	}
	
	// 1. 삽입 
	// 1.1 맨 뒤에 삽입
	void addLast(int data) {
		Node newNode = new Node(data); 
		Node curr = head;
		
		while(curr.link!=null) {
			curr = curr.link;
		}
		curr.link = newNode;
		
		size++;
	}
	
	
	// 1.2 원하는 idx에 삽입
	void add(int idx, int data) {
		if(idx<0 || idx>size) {
			System.out.println("삽입할 수 없는 위치입니다.");
			return;
		}
		
		Node newNode = new Node(data);
		Node curr = head;
		
		for(int i=0; i<idx; i++) {
			curr = curr.link;
		}
		
		newNode.link = curr.link;
		curr.link = newNode;
		
		size++;
	}
	
	// 2. 삭제
	
	void remove(int idx) {
		if(idx<0 || idx>size) {
			System.out.println("삭제할 수 없는 위치입니다.");
			return;
		}
		
		Node curr = head;
		for(int i=0; i<idx; i++) {
			curr = curr.link;
		}
		curr.link = curr.link.link;
		
		size--;
	}
}


public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sbList = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int t=1; t<=10; t++) {
			SinglyLinkedList list = new SinglyLinkedList();
			
			int N1 = Integer.parseInt(br.readLine()); // 원본 암호문 길이 
			st = new StringTokenizer(br.readLine());
			
//			원본 암호문을 addLast로 저장
			
			for(int n=0; n<N1; n++) {
				list.addLast(Integer.parseInt(st.nextToken()));
			}
			
			int N2 = Integer.parseInt(br.readLine()); // 명령어 개수
			st = new StringTokenizer(br.readLine());
			
//			명령어에 맞는 동작 수행
			
			for(int n=0; n<N2; n++) {
				char what = st.nextToken().charAt(0);
				if(what =='I') { // insert
					int idx = Integer.parseInt(st.nextToken());
					int dataNum = Integer.parseInt(st.nextToken());
					for(int i=0; i<dataNum; i++) {
						list.add(idx++,Integer.parseInt(st.nextToken()));
					}
				} else if (what =='D') { // delete
					int idx = Integer.parseInt(st.nextToken());
					int dataNum = Integer.parseInt(st.nextToken());
					for(int i=0; i<dataNum; i++) {
						list.remove(idx);
					}
				}
			}
	        System.out.print("#" + t + " ");
	        printList(list);
		}
	}
	
	static void printList(SinglyLinkedList list) {
		Node curr = list.head;
		for(int i=0; i<10; i++){
			curr = curr.link;
			System.out.print(curr.data+" ");
		}
		System.out.println();
	}
}