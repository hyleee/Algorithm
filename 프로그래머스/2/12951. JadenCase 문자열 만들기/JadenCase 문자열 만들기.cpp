#include <string>
#include <vector>

using namespace std;

string solution(string str){
    string answer = "";
    bool inside = false; // 단어 안에 포함 여부

    for(char c : str){
        if(c==' '){
            answer += " ";
            inside = false; // 다음 글자가 단어의 첫 글자
        } else if(!inside){
            answer += toupper(c);
            inside = true;
        } else{
            answer += tolower(c);
        }
    }
    return answer;
}