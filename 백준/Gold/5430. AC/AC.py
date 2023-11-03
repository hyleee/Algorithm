# R 뒤집기 D 첫 번째 수 버리기

# point1: 괄호와 쉼표를 모두 입력받기 때문에
# 쉼표로 구분하고 대괄호는 지워줘야하기 때문에 [:-1] 범위의 부분만 가져와서 deque를 만들어준다.

# point2: reverse 를 해야할 때마다 매번 deque를 뒤집어주면 시간 초과
# 뒤집는 횟수가 홀수 번 일때만 뒤집도록.
# D가 나오면 cnt 짝수일때 popleft, 홀수일때 pop 하면 되니까.

# point3: n==0일 때 따로 처리

import sys
input=sys.stdin.readline
from collections import deque

t=int(input())
for _ in range(t):
    p=input()
    n=int(input())
    arr=input().strip()[1:-1].split(',')
    queue=deque(arr)

    cnt=0 # 뒤집기 횟수
    flag=1 # error 여부 체크. 정상이라면 1

    if n==0:
        queue=[]
    
    for what in p:
        if what=="R": cnt+=1
        elif what=="D":
            if len(queue)==0:
                print("error")
                flag=0
                break
            else:
                if cnt%2==0: queue.popleft()
                else: queue.pop()
    if flag==0: continue
    else:
        if cnt%2==0: print("["+",".join(queue)+"]")
        else: 
            queue.reverse()
            print("["+",".join(queue)+"]")
