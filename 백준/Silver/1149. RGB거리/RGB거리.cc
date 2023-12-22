#include <iostream>
#include <algorithm>
using namespace std;
#define MAX 1001

int main(){
    int n;
    cin>>n;
    int cost[MAX][3];

    cost[0][0]=0;
    cost[0][1]=0;
    cost[0][2]=0;

    // 누적해서 더해가는 방식

    // cost[i][0] 에는 i번째 집을 r로 칠할 때 최소 비용 -> 이전 집이 g or b
    // cost[i][1] 에는 i번째 집을 g로 칠할 때 최소 비용 -> 이전 집이 r or b
    // cost[i][2] 에는 i번째 집을 b로 칠할 때 최소 비용 -> 이전 집이 r or g

    for(int i=1; i<=n; i++){
        int r, g, b;
        cin>>r>>g>>b;

        cost[i][0]=min(cost[i-1][1], cost[i-1][2])+r;
        cost[i][1]=min(cost[i-1][0], cost[i-1][2])+g;
        cost[i][2]=min(cost[i-1][0], cost[i-1][1])+b; 


    }

    // 주의: min은 2개 값만 비교가능
    cout<<min(cost[n][0], min(cost[n][1], cost[n][2]));
}