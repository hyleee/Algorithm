#include <iostream>
#include <string>
#include <vector>
#include <cmath>
using namespace std;

// 0의 아스키코드가 48

//N (0 ≤ N ≤ 500,000) 이지만 
// 위에서 아래로 내려올 수도 있으므로 1000000까지.


// 1. 채널 조절
// 2. 직접 채널 입력
// 3. 채널 입력 후 조절

// 1. num이 고장난 버튼을 포함하고 있지 않은지 확인
// 2. 포함하지 않는다면 abs(N-num)*(+or-누른 횟수) + len(num)
// 3. 0부터 1000000까지 1~2 과정 반복. 이동 횟수가 최소인 값이 정답  

vector<int> dp;
vector<bool> broken(10, false); //고장 여부

bool check(int now){ // 고장난 버튼이 포함된 채널인지 아닌지 체크
    string s = to_string(now);
    for(int i=0; i<s.length(); i++){
        if(broken[s[i]-48]){
            return false; // 고장난 버튼이 포함된 채널
        }
    }
    return true; // 고장난 버튼이 미포함된 채널
}

int main(){
    int n,m;
    cin>>n>>m;

    int tmp;

    for(int i=0; i<m; i++){
        cin>>tmp;
        broken[tmp]=true;
    }

    string st = to_string(n);

    int minimum = abs(n-100);
    for(int i=0; i<=1000000; i++){
        // 이 때 i는 경유지처럼 활용할 채널 번호
        if(check(i)){ // 고장난 버튼이 포함되어있지않다면
            int tmp = abs(n-i)+to_string(i).length();
            minimum=min(minimum,tmp);
        }
    }
    cout<<minimum;
}
