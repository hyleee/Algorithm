#include <iostream>
#include <map>
using namespace std;

int main(){
    int t;
    cin>>t;

    for(int i=0; i<t; i++){
        int n;
        cin>>n;
        map<string, int> cloth;
        for(int j=0; j<n; j++){

            string name, type;
            cin>>name>>type;
            cloth[type]++;
        }

        int result = 1;
        for(auto x: cloth){
            result *= (x.second+1); 
        }
        cout<<result-1<<"\n";
    }
}