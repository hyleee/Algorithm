#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
#define MAX 1001

string str1, str2;
int dp[MAX][MAX];


int main(){
    ios_base::sync_with_stdio;
    cin.tie(0);
    cout.tie(0);

    cin>>str1>>str2;

    int len1 = str1.length();
    int len2 = str2.length();

    for(int i=0; i<len1; i++){
        for(int j=0; j<len2; j++){
            if(str1[i]==str2[j]){
                dp[i+1][j+1] = dp[i][j] +1;
            }else{
                dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j]);
            }
        }
    }

    cout<<dp[str1.length()][str2.length()] <<"\n";

    return 0;
}