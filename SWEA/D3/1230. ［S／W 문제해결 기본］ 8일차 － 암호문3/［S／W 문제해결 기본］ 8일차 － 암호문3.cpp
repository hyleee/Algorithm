#include <iostream>
#include <string>
#include <vector>
#include <sstream> // 문자열을 stringstream으로 변환하기 위해

using namespace std;

void func(vector<int>& list, char cmd, int x, stringstream& st){
    int y;
    switch(cmd){
        case 'I':
            st>>y; // y개의 암호문 삽입
            for(int i=0, insertIdx=x; i<y; i++, insertIdx++){
                int k;
                st>>k; // 덧붙일 암호문 중 insertIdx 번째 숫자
                list.insert(list.begin() + insertIdx, k); // O(N)
            }
            break;
        case 'D':
            st>>y;
            for(int i=0; i<y; i++){
                list.erase(list.begin()+x); 
            }
            break;
        case 'A':
        // x : 덧붙일 암호문 개수
            for(int i=0; i<x; i++){
                st>>y; // 덧붙일 암호문 중 i번쨰 숫자
                list.push_back(y);
            }
            break;
    }
}



int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for(int t=1; t<=10; t++){
        vector<int> list;
        int N; // 암호문의 개수
        cin>>N; // 
        cin.ignore();

        string line;
        getline(cin, line); // stringTokenizer. 원본 암호문 뭉치
        stringstream st1(line);

        for(int i=0; i<N; i++){
            int num;  
            st1>>num; 
            // 원본 암호문 내의 숫자를 하나씩 벡터에 저장
            list.push_back(num);
        }

        int Q; // 명령어 개수
        cin>>Q; 
        cin.ignore();

        getline(cin, line);
        stringstream st2(line);

        for(int i=0; i<Q; i++){
            char cmd; // 명령어
            st2 >> cmd;
            int x; // 명령에 해당하는 숫자
            st2 >> x;
            func(list, cmd, x, st2);
        }

        cout<<"#"<<t;
        for(int i=0; i<10; i++){
            cout<<" "<<list[i];
        }
        cout<<"\n";
    }
    return 0;
}