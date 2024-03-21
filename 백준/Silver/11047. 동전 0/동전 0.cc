#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    int n, k;
    int cnt=0;
    cin>>n>>k;
    vector<int> price(n);

    for(int i=0; i<n; i++){
        cin>>price[i];
    }

    sort(price.rbegin(), price.rend());

    for(int i=0; i<n; i++){
        if (price[i]<=k){
            cnt+=k/price[i];
            k=k%price[i];
        }
        else continue;
    }

    cout<<cnt;

}