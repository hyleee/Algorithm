#include <iostream>
using namespace std;
#include <queue>

int main(){
    int n, temp;
    int time=0;
    int sum=0;
    priority_queue<int, vector<int>, greater<int>> pq;
    cin>>n;

    for(int i=0; i<n; i++){
        cin>>temp;
        pq.push(temp);
    }

    while(!pq.empty()){
        time=time+pq.top();
        sum+=time;
        pq.pop();
    }
    cout<<sum;
}