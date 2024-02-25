import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Solution {

    static int heapSize;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for (int TC = 1; TC <= T; TC++) {
            int N = Integer.parseInt(br.readLine()); // 연산의 수
            int[] heap = new int[100001]; // 1-based 이므로 최대 연산의 수 + 1
            heapSize = 0;

            System.out.print("#" + TC + " ");

            for (int i = 0; i < N; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int cmd = Integer.parseInt(st.nextToken());

                if (cmd == 1) { // 연산1
                    int num = Integer.parseInt(st.nextToken());
                    heapPush(heap, num);
                } else { // 연산2
                    System.out.print(heapPop(heap) + " ");
                }
            }
            System.out.println();

        }

    }

    static void swap(int[] heap, int a, int b) {

        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;

    }

    static void heapPush(int[] heap, int num) {

        heap[++heapSize] = num;
        int ch = heapSize;
        int p = ch / 2;

        while (p > 0 && heap[p] < heap[ch]) {
            swap(heap, p, ch);
            ch = p;
            p = ch / 2;
        }
    }

    static int heapPop(int[] heap) {

        if (heapSize == 0) {
            return -1;
        }

        int popItem = heap[1];

        heap[1] = heap[heapSize--];

        int p = 1;
        int ch = 2 * p;
        
        while (ch <= heapSize) {
            if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
                ch++;
            }

            if (heap[p] < heap[ch]) {
                swap(heap, p, ch);
                p = ch;
                ch = 2 * p;
            } else {
                break;
            }
        }

        return popItem;

    }

}