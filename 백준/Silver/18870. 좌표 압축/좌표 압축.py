import sys 
input=sys.stdin.readline

n=int(input())
x=list(map(int,input().split()))
# for i in range(n):
#     answer=0
#     for j in range(n):
#         if i==j:
#             continue
#         if x[i]>x[j]:
#             answer+=1
#     print(answer, end=' ')

# 위의 코드는 시간초과가 뜬다.

# 1. set()을 이용해 중복을 제거한다.
numset=set(x)
numset=list(numset)
numset.sort()
# print(numset)

# 2. 딕셔너리를 이용해 숫자를 인덱스로 바꾼다.
numdict={}
for i in range(len(numset)):
    numdict[numset[i]]=i

# 3. 각 숫자의 인덱스를 출력한다.
for num in x:
    print(numdict[num], end=' ')