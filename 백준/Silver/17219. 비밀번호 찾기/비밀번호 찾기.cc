#include <iostream>
using namespace std;
#include <map>

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n,m;
    map<string, string> site;
    string url, pw;
    cin >> n >> m;

    for(int i=0; i<n; i++){
        cin >> url >> pw;
        site[url]=pw;
    }

    for(int i=0; i<m; i++){
        cin >> url;
        cout << site[url] << "\n";
    }

}