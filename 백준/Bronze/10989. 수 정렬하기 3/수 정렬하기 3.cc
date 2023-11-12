#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin>>N;

    int count[10001]={0};

    for(int i=0; i<N; i++){
        int in;
        cin>>in;
        count[in]+=1;
    }

    for(int i=1; i<10001; i++){
        for(int j=0; j<count[i]; j++){
            cout<<i<<'\n';
        }
    }

}