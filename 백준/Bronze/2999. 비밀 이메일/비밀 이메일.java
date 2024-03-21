import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2999
public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              StringTokenizer st = new StringTokenizer(br.readLine());
              String line=st.nextToken();
              int length=line.length();
              int R=0;
        for (int i = 1; i <length ; i++) {
            if(length%i==0){
                int quotient=length/i;
                if(i>quotient) break;
                R=i;
            }
        }
        int C=length/R;
        char[][] arr=new char[R][C];
        int cnt=0;
        for (int i = 0; i <C; i++) {
            for (int j = 0; j < R; j++) {
                arr[j][i]=line.charAt(cnt++);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j]);
            }
        }
        System.out.println();

    }
}
