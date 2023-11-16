#include <iostream>
using namespace std;
#define MAX 501

int n,m;
int grid[MAX][MAX];
bool visited[MAX][MAX]={0,};
int answer;
int dr[4]={-1,1,0,0};
int dc[4]={0,0,-1,1};

void reset(){
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            visited[i][j]=false;
        }
    }
}

void dfs(int r, int c, int depth, int sum){
    if (depth==3){
        answer=max(answer,sum);
        return;
    }
    for(int i=0; i<4; i++){
        int nr = r+dr[i];
        int nc = c+dc[i];

        if(nr<0 || nr>=n || nc<0 || nc>=m){
            continue;
        }
        if(visited[nr][nc]==true){
            continue;
        }
        visited[nr][nc]=true;
        dfs(nr,nc,depth+1,sum+grid[nr][nc]);
        visited[nr][nc]=false;
    }
}

void shp1(int r, int c)
{
	int sum = 0;
	sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2] + grid[r - 1][c + 1];
	answer = max(answer, sum);
}

void shp2(int r, int c)
{
	int sum = 0;
	sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2] + grid[r + 1][c + 1];
	answer = max(answer, sum);
}

void shp3(int r, int c)
{
	int sum = 0;
	sum = grid[r][c] + grid[r + 1][c] + grid[r + 2][c] + grid[r + 1][c + 1];
	answer = max(answer, sum);
}

void shp4(int r, int c)
{
	int sum = 0;
	sum = grid[r][c] + grid[r - 1][c + 1] + grid[r][c + 1] + grid[r + 1][c + 1];
	answer = max(answer, sum);
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    answer=0;

    cin>>n>>m;

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin>>grid[i][j];
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){

            visited[i][j]=true;
            dfs(i,j,0,grid[i][j]);
            visited[i][j]=false;

            if(i-1>=0 && j+2<m){
                shp1(i,j);
            }
            if(i+1<n && j+2<m){
                shp2(i,j);
            }
            if(i+2<n && j+1<m){
                shp3(i,j);
            }
            if(i-1>=0 && i+1<n && j+1<m){
                shp4(i,j);
            }
        }
    }
    cout<<answer;
}



