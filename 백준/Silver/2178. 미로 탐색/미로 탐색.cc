#include <iostream> 
#include <queue>
using namespace std;
#define MAX 101

int maze[MAX][MAX]; // 2차원 배열 0으로 초기화
int visited[MAX][MAX];
int result[MAX][MAX];

int dx[4]={-1,1,0,0};
int dy[4]={0,0,-1,1};

queue<pair<int, int>> q;
int n, m;

void bfs(int x, int y){
    visited[x][y]=1;
    q.push(make_pair(x,y));
    result[x][y]++;

    while(!q.empty()){
        int x=q.front().first;
        int y=q.front().second;

        q.pop();

        for(int i=0; i<4; ++i){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if((nx>=0 && nx<n) && (ny>=0 && ny<m) && (visited[nx][ny]==0) && (maze[nx][ny]==1)){
                visited[nx][ny]=1;
                result[nx][ny]=result[x][y]+1;
                q.push(make_pair(nx,ny));
            }
        }
    }
}

int main(){
    
    // ios_base::sync_with_stdio(false);
    // cin.tie(0);
    // cout.tie(0);

    cin>>n>>m;

    for(int i=0; i<n; i++){
        string row;
        cin>>row;

        for(int j=0; j<m; j++){
            maze[i][j]=row[j]-'0';
        }
    }

    bfs(0,0);
    cout<<result[n-1][m-1];

}
