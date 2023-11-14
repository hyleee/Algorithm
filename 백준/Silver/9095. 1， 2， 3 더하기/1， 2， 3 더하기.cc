#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int t, n;
    cin>>t;

    vector<int> dp(12,0); // 크기 12의 벡터를 0으로 초기화

    dp[1]=1;
    dp[2]=2;
    dp[3]=4;
    
    for(int i=4; i<12; i++){
        dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
    }

    for(int i=0; i<t; i++){
        cin>>n;
        cout<<dp[n]<<"\n";
    }
}