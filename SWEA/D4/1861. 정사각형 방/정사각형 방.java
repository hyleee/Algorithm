import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가이드 라인
// 정확히 1 더 커야한다는 조건 때문에 visit 배열 불필요 
// 이동할 때마다 각 점에 대해 상하좌우를 살펴야 하므로 재귀 함수 필요

// 이걸 for i, for j 내에서 반복: 
// 한 점에서 시작
// 상하좌우 탐색 -> 배열 범위 내에 있고 && 1보다 크면 1칸 직진 후 cnt++
// 해당 점에서 상하좌우 탐색 -> ,,
// 계속 반복후 최종 cnt를 지금까지의 max와 비교

// 상하 좌우 탐색 후 이동을 반복해야 하니까 함수로 따로 빼자

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, maxCnt=0, maxRoom;
	static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(in.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
 
            N = Integer.parseInt(in.readLine());
            arr = new int[N][N];
            maxRoom = 0;
            maxCnt = 0;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    moveRoom(i, j, 1);
                }
            }
            
            sb.append(maxRoom).append(" ").append(maxCnt).append("\n");
        }
        System.out.print(sb);
    }

    private static int moveRoom(int i, int j, int cnt) {
        for (int d = 0; d < 4; d++) {
        	// 1. nr, nc 일단 만들기
            int ni = i + dr[d];
            int nj = j + dc[d];
            
            // 2. 조건 검사
            // 배열 밖에 있으면 다른 방향 탐색
            // 정확히 1 큰 값 아니여도 다른 방향 탐색
            if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
            else if (arr[i][j] + 1 != arr[ni][nj]) continue;
            
            // 3. 탐색
            cnt = moveRoom(ni, nj, cnt + 1);
            
            // 4. 최댓값 갱신
            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxRoom = arr[i][j];
            } else if (maxCnt == cnt && maxRoom > arr[i][j]) {
                maxRoom = arr[i][j];
            }
            
            // 재귀 stack 비울 때  break로 탈출하도록
            break; 
        }
 
        return cnt;
 
    }
}