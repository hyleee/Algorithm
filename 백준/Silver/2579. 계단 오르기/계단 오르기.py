# 마지막 계단은 무조건 밟아야하므로 마지막 계단에서부터 거꾸로

import sys
input=sys.stdin.readline

n=int(input())
stair=[0]*(301)
for i in range(1,n+1):
    stair[i]=int(input())


# n 번째 계단에 올라오기 위한 경우의수
# 1. n-1번째 계단을 밟고 올라온 경우 (연속 세칸 불가능이니까)
# dp[n]=dp[n-3]+stair[n-1]+stair[n]
# 2. n-2번째 계단을 밟고 올라온 경우
# dp[n]=dp[n-2]+stair[n]

# 이 두가지 경우의 수 중 더 큰 경우가 dp[n]이다.

# dp[i]는 i번째 계단을 밟았을 때의 최댓 점수
dp=[0]*(301) # index는 0부터 n까지. 1-based
# n-3까지 초기 값이 있어야하므로
dp[1]=stair[1]
dp[2]=stair[1]+stair[2]
dp[3]=max(stair[1]+stair[3], stair[2]+stair[3])

for i in range(4, n+1):
    dp[i]=max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i])

print(dp[n])

