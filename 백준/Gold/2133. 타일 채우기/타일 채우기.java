import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://january-diary.tistory.com/entry/BOJ-2133-%ED%83%80%EC%9D%BC-%EC%B1%84%EC%9A%B0%EA%B8%B0-JAVA

//dp[2] = 3
//dp[4] = dp[2] * dp[2] + 2 = 3*3 +2(특) = 11
//dp[6] = dp[4]*dp[2] + dp[2]*2 +2(특)
//dp[8]= dp[6]*dp[2] + dp[2]*2(특) + dp[4]*2(특) +2

//dp[N] = dp[N-2]*dp[2] + dp[N보다작고2보다큰짝수]*2의 총합  +2

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N%2==1){
            System.out.println(0);
            return;
        }

        int[] dp = new int [N+1];
        dp[2]=3;
        for(int i=4; i<=N; i+=2){
            dp[i] = dp[i-2]*dp[2] +2;
            for(int j=i-2; j>=4; j-=2){
                dp[i] += dp[i-j]*2;
            }
        }
        System.out.println(dp[N]);

    }
}