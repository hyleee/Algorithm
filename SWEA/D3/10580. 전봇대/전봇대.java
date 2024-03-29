import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                arr[n][0] = Integer.parseInt(st.nextToken());
                arr[n][1] = Integer.parseInt(st.nextToken());
            }
            
            int cnt=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][0]<arr[j][0] && arr[i][1]>arr[j][1]) cnt++;
                }   
            }
            sb.append("#"+t+" "+cnt+"\n");       
        }
        System.out.println(sb);
    }
}