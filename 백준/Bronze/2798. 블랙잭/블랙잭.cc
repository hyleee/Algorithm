#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
	int caseNum, N, M, num, result;
	result = 0;

	cin >> N >> M;
	int arr[101] = {};
	for (int i = 0; i < N; i++) {
		cin >> num;
		arr[i] = num;
	}
	
	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j < N; j++) {
			for (int k = j + 1; k < N; k++) {
				if (arr[i] + arr[j] + arr[k] <= M && arr[i] + arr[j] + arr[k] > result) {
					result = arr[i] + arr[j] + arr[k];
				}
			}
		}
	}
	cout << result;

}