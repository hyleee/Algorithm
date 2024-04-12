import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str) {
        int minLength = Integer.MAX_VALUE;
        if(str.length()==1) return 1;
        
        
        // i개 단위로 잘라 압축하기
        for(int i=1; i<=str.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String prevStr = str.substring(0, i); // 이전 문자열은 첫 번째 문자열 덩어리로 초기화 
            int cnt=1 ; // 몇 개 연속인지 저장
            
            for(int j=i; j<=str.length()-i; j+=i){
                String curStr = str.substring(j, j+i);
                
                // 문자열 연속 여부 체크
                if(prevStr.equals(curStr)){ // 1) 일치하다면
                    cnt++;
                } else if(cnt >1){ // 2) 일치했던 부분 종료. 이제 sb에 추가
                    sb.append(cnt).append(prevStr);
                    cnt=1;
                } else{ // 그동안 일치하지도 않았고, 이번에도 일치하지X
                    // 문자열 그대로 추가
                    sb.append(prevStr);
                }
                prevStr = curStr; //비교 문자열 갱신
                
            } 
            // 마지막 덩어리 추가
            sb.append(cnt>1? cnt : "").append(prevStr);
            
            // 압축 단위로 나누어 떨어지지 않을 경우 남아있는 부분 처리
            if(str.length()%i!=0){
                sb.append(str.substring(str.length()-str.length()%i, str.length()));
            }
            minLength = Math.min(minLength, sb.length());
        }
        
        return minLength;
    }
}
