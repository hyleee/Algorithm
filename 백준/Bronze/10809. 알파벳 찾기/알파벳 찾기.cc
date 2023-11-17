#include <iostream>
#include <string>
using namespace std;

// string 의 멤버 함수 find
// string str="아무 문자열";
// str.find("원하는 문자 혹은 문자열", startindex(생략가능));
// 있으면 해당 문자열의 첫번째 인덱스, 없으면 -1 반환

int main(){
    string s;
    string alphabet="abcdefghijklmnopqrstuvwxyz";
    cin>>s; 
    // 65 97 122

    for(int i=0; i<alphabet.length(); i++){
        cout<< (int)s.find(alphabet[i])<<" ";
    }
}
