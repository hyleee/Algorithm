#include <iostream>
#include <queue>
#include <sstream>
#include <string>
#include <cstring>

using namespace std;
#define MAX 50


int w, h;
int map[MAX][MAX];
bool visited[MAX][MAX]={0};
int dr[8] = { -1, -1, -1, 0,0, 1,1,1};
int dc[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
queue<pair<int, int>> q;

void bfs(int i, int j){

    visited[i][j]=true;
    q.push({i,j});

    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        for(int d=0; d<8; d++){
            int nr = r + dr[d];
            int nc = c+ dc[d];
            if(nr<0 || nc<0 || nr>=h || nc>=w) continue;
            if(map[nr][nc] && !visited[nr][nc]){
                q.push({nr, nc});
                visited[nr][nc] = 1;
            }
        }        
    }
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);

    while(1){

        int cnt=0;
        cin>>w>>h;

        if(!w && !h) break;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                cin>>map[i][j];
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(!visited[i][j]&&map[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        cout<<cnt<<"\n";
        memset(visited, 0, sizeof(visited));
    }
}