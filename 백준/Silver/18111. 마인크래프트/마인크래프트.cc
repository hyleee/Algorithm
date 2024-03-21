#include <iostream>
using namespace std;

int main(){
    int n,m,b;
    int map[500][500];

    // 갱신해줄 답
    int answerTime=0x7f7f7f7f;
    int answerHeight;

    cin>>n>>m>>b;

    for(int i=0; i<n;i++)
        for(int j=0; j<m; j++)
            cin>>map[i][j];
    
    // 모든 높이에 대해 시간을 계산해보자.
    for(int h=0; h<=256; h++){
        // 작업 행위와 횟수를 저장해 나중에 시간계산에 활용하자.
        int build=0;
        int remove=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int height=map[i][j]-h;
                if(height>0) remove+=height;
                else if (height<0) build-=height;
            }
        }
        
        // 수거한 블록 개수 + 원래 인벤에 있던 개수 >= 쌓아야할 블록 개수
        if(remove+b>=build){
            int time = remove*2 + build;
            if(answerTime>=time){
                answerTime=time;
                answerHeight=h;
            }
        }
    }
    cout<<answerTime<<" "<<answerHeight<<'\n';
}