import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr= list((map(int,input().split())))

# arr 원소 5개(0부터 n-1) dp 원소 6개(0부터 n)
# dp = [[0] for _ in range(n+1)]

# for i in range(1, n):
#     dp[i] = dp[i-1] + arr[i-2] 

sum_value = 0
dp =[0]

for num in arr:
    sum_value += num
    dp.append(sum_value)
    
for _ in range(m):
    start, end = map(int, input().split())  
    answer = dp[end]-dp[start-1]
    print(answer)