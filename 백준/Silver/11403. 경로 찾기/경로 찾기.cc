#include <iostream>
#define MAX 102
#include <vector>
#include <cstring>
using namespace std;

vector<int> v[MAX];
int visit[MAX];

void dfs(int x){
    // visit[v[x][x]]=1;
    for(int i=0; i<v[x].size(); i++){
        if(!visit[v[x][i]]){
            visit[v[x][i]]=1;
            dfs(v[x][i]);
        }
    }
}

int main(){
    int n;
    cin>>n;

    int tmp;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin>>tmp;
            if(tmp==1){
                v[i].push_back(j);
            }
        }
    }
    for(int i=0; i<n; i++){
        memset(visit,0,sizeof(visit));
        dfs(i);
        for(int j=0; j<n; j++){
            cout<<visit[j]<<" ";
        }
        cout<<"\n";
    }
}