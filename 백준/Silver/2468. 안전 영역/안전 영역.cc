#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;
#define MAX 100

int N;
int map[MAX][MAX];
int safe[MAX][MAX];
int visited[MAX][MAX];
int dr[] = { 0,0,-1,1 };
int dc[] = { -1,1,0,0 };
int maxHeight = -1;
vector<int> v;
queue<pair<int, int>> q;

void bfs(int i, int j){
    visited[i][j]= 1;
    q.push(make_pair(i, j));

    while(!q.empty()){
        
        int r = q.front(). first;
        int c = q.front().second;
        q.pop();

        for(int d=0; d<4; d++){
            int nr = r+ dr[d];
            int nc = c+ dc[d];

            if(nr<0 || nc<0 || nr>=N || nc>=N){
                continue;
            }
            if(safe[nr][nc] && !visited[nr][nc]){
                q.push({nr, nc});
                visited[nr][nc] = 1;
            }
        }

    }
}


void reset(){
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            safe[i][j] =0;
            visited[i][j]=0;
        }
    }
}

int main(){

    cin>>N;
    
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin>>map[i][j];
            if(map[i][j]>maxHeight){
                maxHeight = map[i][j];
            }
        }
    }

    // 물에 잠길 수 있는 모든 높이에 대해
    for(int h=1; h<=maxHeight; h++){

        // 안전 영역 표시
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]<h){
                    safe[i][j]=0;
                }else{
                    safe[i][j]=1;
                }
            }
        }

        // 영역 개수 카운트
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(safe[i][j] && !visited[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        v.push_back(cnt);
        reset();
    }

    sort(v.begin(), v.end());
    cout<<v[v.size()-1];
}