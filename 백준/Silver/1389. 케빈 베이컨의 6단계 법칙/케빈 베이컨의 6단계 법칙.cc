#include <iostream>
#include <queue>
#include <vector>
using namespace std;
#define MAX 102

queue<int> q; // 현재 탐색 진행중인 사람 번호 저장용
int user[MAX][MAX];
int visited[MAX]; // pair 굳이 만들려고 하지말고 방문배열에 누적해서 베이컨 저장
int peopleNum;
int relation;
int minimum=9999999;
int answer;

void init(){
    for(int i=1; i<=peopleNum; i++){
        visited[i]=0;
    }
}

void BFS(int start){
    visited[start]=1;
    q.push(start);

    while(!q.empty()){
        start=q.front();
        q.pop();
        for(int i=1; i<=peopleNum; i++){
            if(user[start][i]==1 && visited[i]==0){
                visited[i]=visited[start]+1;
                q.push(i);
            }
        }
    }
}

int main(){
    
    cin>>peopleNum>>relation;

    int a, b;
    for(int i=1; i<=relation; i++){
        cin>>a>>b;
        user[a][b]=1;
        user[b][a]=1;
    }
    for(int i=1; i<=peopleNum; i++){
        init();
        BFS(i);

        int sum=0;
        for(int j=1; j<=peopleNum; j++){
                if(i==j) continue;
                else sum+=visited[j];
            }
        if(sum<minimum){
            minimum=sum;
            answer=i;
            } 
    }
    cout<<answer;
}