#include <iostream>
#include <string>

using namespace std;

int main(){
    int T;
    cin>>T;
    int total = (1<<10)-1; // 모든 숫자가 등장했을 때의 값

    for(int t=1; t<=T; t++){
        int N;
        cin>>N;

        int cnt=0;
        int visitedNum =0;

        while(true){
            string strNum = to_string(N*(++cnt)); // N*cnt 값을 문자열로 표현한 것
            
            for(char c: strNum){
                int num = c-'0';
                visitedNum |= (1 << num);
            }
            if(visitedNum ==total) //모든 숫자가 등장했다면 종료
                break;
        }
        cout<<"#"<<t<<" "<<N*cnt<<endl;
    }
    return 0;
}