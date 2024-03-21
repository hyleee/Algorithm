// 짝수 중인 것 중에 5로 나누어 떨어지는 것을,,,

#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
    int N;
    int cnt=0;
    
    cin>>N;
    for(int i=5; i<=N; i*=5){
        cnt+=N/i;
    }
    cout<<cnt;
}