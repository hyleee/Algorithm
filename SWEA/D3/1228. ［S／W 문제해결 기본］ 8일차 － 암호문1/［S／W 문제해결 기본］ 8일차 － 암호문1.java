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
	
	// 삽입
	// 1. 제일 뒤에 삽입
	void addLast(int data) {
		Node newNode = new Node(data);
		
		Node curr = head;
		while(curr.link!= null){
			curr = curr.link;
		}
		
		curr.link = newNode;  // newNode가 마지막 노드가 됨 
		size++;
	}

	// 2. 원하는 idx에 삽입
	void add(int idx, int data) {
		if(idx<0 || idx>size) {
			System.out.println("삽입할 수 없는 위치입니다.");
			return;
		}
		
		Node curr = head;
		for(int i=0; i<idx; i++) {
			curr = curr.link;
		}
		
		Node newNode = new Node(data);
		
		newNode.link = curr.link;
		curr.link = newNode;
		
		size++;
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
			
			int N1 = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N1; n++) {
				list.addLast(Integer.parseInt(st.nextToken()));
			}
			int N2 = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N2; n++) {
				st.nextToken(); // | 버리기
				int idx = Integer.parseInt(st.nextToken());
				int dataNum = Integer.parseInt(st.nextToken());
				for(int i=0; i<dataNum; i++) {
					list.add(idx++,Integer.parseInt(st.nextToken()));
				}
			}
	        System.out.print("#" + t + " ");
	        printList(list);
		}
	}
	
	static void printList(SinglyLinkedList list) {

		Node curr =  list.head.link;
		for(int i=0; i<10; i++) {
			System.out.print(curr.data+" ");
			curr = curr.link;
		}
		System.out.println();
	}
}