#include <iostream>
using namespace std;
#define max 129

int paper[max][max];
int white=0;
int blue=0;

void cnt(int x, int y, int k){
    bool cut = false;
    int first_color = paper[x][y];

    for(int i=x; i<x+k; i++){
        for(int j=y; j<y+k; j++){
            if(paper[i][j] != first_color){
                cut=true;
                break;
            }
        }
    }

    if(cut){
        cnt(x,y,k/2);
        cnt(x, y+k/2, k/2);
        cnt(x+k/2, y, k/2);
        cnt(x+k/2, y+k/2, k/2);
    }
    else{
        if(first_color==0){
            white++;
        }
        else{
            blue++;
        }
    }
}

int main(){
    int n; 
    cin>>n;

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin>>paper[i][j];
        }
    }

    cnt(0,0,n);
    cout << white << '\n' << blue << '\n';
}