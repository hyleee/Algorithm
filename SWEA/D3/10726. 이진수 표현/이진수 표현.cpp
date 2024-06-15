#include <iostream>
#include <string>

using namespace std;

int main(){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin>>T;

    for(int t=1; t<=T; t++){
        int N, M;
        cin>>N>>M;

        int lastNBit = (1<<N) -1; //(길이 N)
        if(lastNBit == (M & lastNBit)){ // and 연산한 결과가 lastNBit와 같다면
            cout<<"#" <<t << " " << "ON"<<endl;
        } else{
            cout<<"#" <<t << " " << "OFF"<<endl;
        }
    }
}