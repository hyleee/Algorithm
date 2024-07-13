import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int c1c2Diff = Math.abs(c1-c2);

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            int cnt=0;
            int[] cow = new int[N];

            // 소 입력
            for(int n=0; n<N; n++){
                cow[n] = Integer.parseInt(st1.nextToken());
            }
            // 소 정렬
            Arrays.sort(cow);

            // 말 입력
            for(int m=0; m<M; m++){
                int hPos =  Integer.parseInt(st2.nextToken());
                int rightCowIdx = binarySearch(cow, hPos); // // hPos 이상인 소들 중에서 제일 왼쪽 소의 인덱스 찾기


                // 1. hPos 와 cow[upCowIdx] 사이의 거리 계산
                // binarySearch에서 arr.length를 반환하지 않은 이상 아래 조건식은 만족하게 된다.
                // 모든 소들보다 hPos가 큰 경우를 방지해서 작성한 조건문.
                if(rightCowIdx < cow.length){ // hPos 오른쪽에 소가 존재한다면
                    int dist = cow[rightCowIdx] - hPos;
                    if(min == dist){ // 현재 최소 거리와 같다면 경우의 수 증가
                        cnt++;
                    } else if(min > dist){ // 현재 최소 거리보다 작다면 최소 거리 갱신
                        min = dist;
                        cnt=1; // 경우의 수 초기화
                    }
                }

                // 2. hPos와 cow[upCowIdx-1] 사이의 거리 계산
                if(rightCowIdx -1 >=0){ // idxError 방지. hPos 왼쪽에 소가 한 마리라도 존재한다면
                    int dist = hPos - cow[rightCowIdx-1];
                    if(min==dist){
                        cnt++;
                    }else if(min>dist){
                        min = dist;
                        cnt =1;
                    }
                }
            }
            sb.append("#"+t+ " " + (c1c2Diff+min)+ " "+cnt+ "\n");
        }
        System.out.println(sb);
    }

    // arr에서 value 이상인 첫 번째 위치를 찾음
    private static int binarySearch(int[] arr , int value){
        int ans = arr.length; // 만약 arr에 value이상인 요소가 없다면 answer은 arr.length
        int L=0, R = arr.length-1, mid=0;

        while(L<=R){
            mid =  (L+R)/2;
            if(arr[mid] >=value){ // value 이상인 위치를 보고 있다면
                ans = mid;
                R = mid-1; // 왼쪽 절반을 탐색
            } else{ // value 미만인 위치를 보고 있다면
                L = mid+1; // 오른쪽 절반을 탐색
            }
        }

        return ans; // value 이상인 첫 번째 위치 반환
    }
}