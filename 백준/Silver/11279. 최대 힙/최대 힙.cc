#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>   
using namespace std;

int main(){
    int n, x;
    vector<int> answer;
    priority_queue<int> pq;
    cin>>n; 

    for(int i=0; i<n; i++){
        cin>>x;
        if(x==0 && !pq.empty()){
            answer.push_back(pq.top());
            pq.pop();
        }
        else if(x==0 && pq.empty()){
            answer.push_back(0);
        }
        else{
            pq.push(x);
        }
    } 

    for (int i=0; i<answer.size(); i++){
        cout<<answer[i]<<'\n';
    }
}