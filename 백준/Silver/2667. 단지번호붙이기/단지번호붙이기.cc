#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define MAX 26

int n;
int house=0;
int map[MAX][MAX];
bool visited[MAX][MAX]={0,};
vector<int> result;

int dx[4]={-1,1,0,0};
int dy[4]={0,0,-1,1};

void dfs(int x, int y){ 
    visited[x][y]=1;
    house++;

    for(int i=0; i<4; i++){
        int nx=x+dx[i];
        int ny=y+dy[i];

        if (nx<0 || nx>=n || ny<0 || ny>=n){
            continue;
        }
        
        if (visited[nx][ny]==0 && map[nx][ny]==1){
            dfs(nx,ny);            
        }
    }
}

int main(){
    cin>>n;

    for(int i=0; i<n; i++){
        string row;
        cin>>row;
        for(int j=0; j<n; j++){
            map[i][j]=row[j]-'0';
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(map[i][j]==1 && visited[i][j]==0){
                house=0;
                dfs(i,j);
                result.push_back(house);
            }
        }
    }

    sort(result.begin(), result.end());

    cout<<result.size()<<"\n";
    for(int i=0; i<result.size(); i++){
        cout<<result[i]<<"\n";
    }
}

