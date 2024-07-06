import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int [N+1];
        int[] dp = new int [N+1]; // i번째 원소를 마지막으로 포함하는 증가 부분 수열의 최대 합

        for(int n=1; n<=N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            // 모든 숫자(i)를 증가부분수열의 가장 큰 숫자로 가정해보자.
            dp[i] = arr[i]; // 일단 자기 자신을 기준점으로
            for(int j=1; j<i; j++){
                if(arr[i] > arr[j]){ // j->i로 올 때 증가한다면
                    // dp[i] 갱신
                    // 여태까지 쌓인 증가수열의 총 합
                    // dp[i] 와 arr[i]와는 엄연히 다르다. 주의!!!
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
//                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            if(dp[i]>max) max = dp[i];
        }

        System.out.println(max);
    }
}