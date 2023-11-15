#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 끝나는 시간을 기준으로!!!

int main(){
    int n;
    cin>>n;
    vector<pair<int,int>> time;

    for(int i=0; i<n; i++){
        int start, end;
        cin>>start>>end;
        time.push_back(make_pair(end, start)); // 끝나는 시간 기준 정렬을 위해 end를 pair1으로!**
    }

    sort(time.begin(), time.end()); // 끝나는 시간 기준 오름차순

    int end=time[0].first; // 가장 먼저 끝나는 회의를 저장
    int cnt=1;

    for (int i=1; i<n; i++){
        int new_end = time[i].first;
        if(end<=time[i].second){
            end=new_end;
            cnt++;
        }
    }
    cout<<cnt;
}