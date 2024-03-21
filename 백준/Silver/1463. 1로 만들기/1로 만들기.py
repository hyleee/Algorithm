import sys
input=sys.stdin.readline

n=int(input())

# 각 index 숫자마자 1이 되기위해 필요한 연산 횟수를 저장하는 배열
d=[0]*(n+1) # 1-based


for i in range(2,n+1):
    d[i]=d[i-1]+1
    if i%2==0:
        # 2로 나누어 떨어지더라도 바로 2로 나누는게 아니고, 비교 후 연산
        d[i]=min(d[i],d[i//2]+1)
        # d[i//2]+1 은 i를 2로 나눈 값이 1이 되기위한 연산 횟수 + i를 2로 나누는 연산 횟수 1회
    if i%3==0:
        d[i]=min(d[i], d[i//3]+1)
print(d[n])

