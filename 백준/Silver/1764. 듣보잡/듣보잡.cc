#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    map<string, int> namelist;
    vector<string> answer;

    int n,m;
    cin>>n>>m;

    for(int i=0; i<n+m; i++){
        string name;
        cin>>name;
        namelist[name]++;

        if(namelist[name]>1){
            answer.push_back(name);
        }
    }

    sort(answer.begin(), answer.end());
    cout<<answer.size()<<"\n";

    for(int i=0; i<answer.size(); i++){
        cout<<answer[i]<<'\n';
    }

}