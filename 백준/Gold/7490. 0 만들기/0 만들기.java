import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<String> answer;
    static String[] op = {"+", "-", " "};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            answer = new ArrayList<>();
            dfs(N, 1, "1");
            Collections.sort(answer);
            for(String str : answer){
                System.out.println(str);
            }
            System.out.println();
        }
    }

    static void dfs(int N, int cnt, String str){
        if(cnt==N){ // 호출 횟수가 N에 다다랐으면
            // 계산 결과가 0이면 answer에 추가
            if(calculate(str)==0) answer.add(str);
            return;
        }

        for(int i=0; i<3; i++){
            dfs(N, cnt+1, str+op[i]+Integer.toString(cnt+1));
        }
    }

    static int calculate(String str){
        str = str.replaceAll(" ", "");
        StringTokenizer st = new StringTokenizer(str, "-+", true);
        int result = Integer.parseInt(st.nextToken());

        while(st.hasMoreElements()){
            String input = st.nextToken();
            if(input.equals("+")){
                result+= Integer.parseInt(st.nextToken());
            }else{
                result -= Integer.parseInt(st.nextToken());
            }
        }
        return result;


    }
}