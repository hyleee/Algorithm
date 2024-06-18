#include <iostream>
#include <string>

using namespace std;

int solution(string str){
    int answer=str.size();

    for(int i=1; i<=str.size()/2; i++){
        int cnt =1;
        string temp = "";
        string part = "";
        part = str.substr(0, i);
        for(int j=i; j<str.size(); j+=i){
            // 반복 구간이라면
            if(part == str.substr(j, i)) cnt++;
            // 반복 구간 끝났다면 이제 청산
            else{
                if(cnt>1){
                    temp += to_string(cnt);
                } 
                temp += part;

                // 초기화
                part = str.substr(j, i);
                cnt=1;
            }   
        }

        if(cnt>1){
            temp += to_string(cnt);
        } 
        temp += part;
        if(answer>temp.size()){
            answer = temp.size();
        }
    }
    
    return answer;
}