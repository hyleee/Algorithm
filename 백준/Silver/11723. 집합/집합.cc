#include <cstring>
#include <iostream>
using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    string str = "";
    int m, x;
    int arr[21]={0};

    cin >> m;

// add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
// remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
// check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
// toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
// all: S를 {1, 2, ..., 20} 으로 바꾼다.
// empty: S를 공집합으로 바꾼다.

    for(int i=0; i<m; i++){
        cin >> str;

        if(str=="add"){
            cin >> x;
            if(arr[x]==0){
                arr[x]=1; // 추가를 이렇게 하는구나..
            }
        }

        else if(str=="remove"){
            cin >> x;
            if(arr[x]==1){
                arr[x]=0;
            }
        }

        else if(str=="check"){
            cin>>x;
            if(arr[x]==1){
                cout<<"1\n";
            }
            else{
                cout<<"0\n";
            }
        }

        else if(str=="toggle"){
            cin>>x;
            if(arr[x]==1){
                arr[x]=0;
            }
            else{
                arr[x]=1;
            }
        }

        else if(str=="all"){
            for(int k=1; k<=20; k++){
                arr[k]=1;
            }
        }

        else if(str=="empty"){
            memset(arr, 0, sizeof(arr));
        }
    }
}
