# 내구도 0인 칸 개수 K개 이상이면 break

import sys
input=sys.stdin.readline
from collections import deque

# 내구도 0인 칸은 따로 변수로 저장할 필요 없음 주의

n, k = map(int, input().split())
belt = deque(list(map(int, input().split())))
robot = deque([0]*n) # 로봇이 있으면 1 없으면 0
level=0 # 단계

while True:
    belt.rotate(1)
    robot.rotate(1)
    robot[-1]=0 # 로봇이 내려가는 위치니까 0 

    if sum(robot): # 벨트 위 로봇이 한 개라도 있다면
        for i in range(n-2,-1,-1):
            if robot[i]==1 and robot[i+1]==0 and belt[i+1]>=1:
                robot[i+1]=1
                robot[i]=0
                belt[i+1]-=1
        robot[-1]=0 # 로봇out !!!!!    
    # 새로운 로봇 올리기
    if belt[0]>=1 and robot[0]==0:
        robot[0]=1
        belt[0]-=1
    level+=1
    if belt.count(0)>=k: break

print(level)