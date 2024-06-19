#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int N;

bool compare(string a, string b){
    if(a[N]==b[N]){
        return a<b;
    }
    else{
        return a[N] <b[N];
    }
}

vector<string> solution(vector<string> str, int n){
    N = n;
    sort(str.begin(), str.end(), compare);
    return str;
}