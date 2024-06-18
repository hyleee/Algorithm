#include <iostream>
#include <queue>
#define MAX 100

using namespace std;
int N, M;
int map[MAX][MAX];
int visited[MAX][MAX];
int dist[MAX][MAX];

queue<pair<int, int>> q;
int dr[4] = {-1, 1, 0, 0}; 
int dc[4] = {0, 0, -1, 1}; 

void bfs(int i, int j){
    visited[i][j] = 1;
    q.push({i, j});
    dist[i][j]++;

    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;

        q.pop();

        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr<0 || nc<0 || nr>=N || nc>=M ){
                continue;
            }
            if(!visited[nr][nc] && map[nr][nc]==1){
                visited[nr][nc] = 1;
                q.push({nr, nc});
                dist[nr][nc] = dist[r][c] + 1;
            }
        }
    }

}


int main(){
    cin>>N>>M;
    for(int n=0; n<N; n++){
        string str;
        cin>>str;

        for(int m=0; m<M; m++){
            map[n][m] = str[m]-'0';
        }
    }
    bfs(0,0);
    cout<<dist[N-1][M-1]<<'\n';
}