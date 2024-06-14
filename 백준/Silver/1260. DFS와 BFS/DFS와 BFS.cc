#include <iostream>
#include <queue>

using namespace std;
#define MAX 1001


int N, M, V;
int arr[MAX][MAX];
bool visited[MAX] ={ 0,};
queue<int> q;

void reset(){
    for(int i=1; i<=N; i++){
        visited[i]=0;
    }
}

void DFS(int v){
    visited[v]=true;
    cout<<v<<" ";

    for(int i=1; i<=N; i++){
        if(arr[v][i]==1 && visited[i]==false){
            DFS(i);
        }
    }
}

void BFS(int v){
    q.push(v);
    visited[v]=true;
    cout<<v<<" ";

    while(!q.empty()){
        v=q.front();
        q.pop();

        for(int i=1; i<=N; i++){
            if(arr[v][i]==1 && visited[i]==false){
                q.push(i);
                visited[i]=true;
                cout<<i<<" ";
            }
        }
    }
}



int main() {
    cin>> N>>M>>V;
    for(int i=0; i<M; i++){
        int a, b;
        cin>>a>>b;
        arr[a][b] = 1;
        arr[b][a] =1 ;
    }

    reset();
    DFS(V);

    cout<<'\n';

    reset();
    BFS(V);
}