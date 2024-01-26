import java.util.*;
import java.io.*;

public class Main {

    static int[][] bingo;
    static int count; // 빙고 개수 

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        bingo = new int[5][5];
        count = 0;

        // 빙고판 입력
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                bingo[i][j] = sc.nextInt();
            }
        }

        for(int k = 1; k <= 25; k++) {
            int num = sc.nextInt();

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(bingo[i][j] == num) 
                        bingo[i][j] = 0;
                }
            }

            rCheck();
            cCheck();
            lrCheck();
            rlCheck();

            if(count >= 3) { // 3줄 이상 빙고
                System.out.println(k);
                break;
            }
            count = 0;
        }
    }

    //가로 
    public static void rCheck() {
        for(int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if(bingo[i][j] == 0)
                    zeroCount++;
            }
            if(zeroCount == 5)
                count++;
        }
    }

    // 세로 
    public static void cCheck() {
        for(int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if(bingo[j][i] == 0)
                    zeroCount++;
            }
            if(zeroCount == 5)
                count++;
        }
    }

    // 왼오 대각선
    public static void lrCheck() {
        int zeroCount = 0;
        for(int i = 0; i < 5; i++) {
            if(bingo[i][i] == 0)
                zeroCount++;
        }
        if(zeroCount == 5)
            count++;
    }

    // 오왼
    public static void rlCheck() {
        int zeroCount = 0;
        for(int i = 0; i < 5; i++) {
            if(bingo[i][4-i] == 0)
                zeroCount++;
        }
        if(zeroCount == 5)
            count++;
    }
}