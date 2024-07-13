import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            long N=Long.parseLong(br.readLine()); // 양초개수


            long L = 1; // 최소 1단
            long R = 10000000000L; // 최대 단수 *10 (여유분)
            long res =0; // 최대 단일 때 촛불 수 (정답)

            while(L<=R){
                long mid = (L+R)/2; // 임시 단 수
                long value = mid*(mid+1)/2; // 임시 촛불 수

                if(N>=value){
                    res = mid;
                    L = mid+1;
                } else{
                    R= mid-1;
                }
            }

            long value = res *(res+1)/2;
            if(N!=value){
                res =-1;
            }
            sb.append("#"+ t+ " "+ res+"\n");
        }
        System.out.print(sb);
    }
}