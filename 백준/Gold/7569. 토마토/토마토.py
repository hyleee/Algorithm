from collections import deque
import sys
input=sys.stdin.readline

# 주의1. index 거꾸로 호출
# 주의2. visited 배열 필요 없이 짜보기


m,n,h=map(int, input().split())

# m개의 길이를 가진 리스트 * n개 * h개
tomato=[[list(map(int,input().split())) for _ in range(n)] for _ in range(h)]
# print(tomato)
# tomato[h][n][m]

dx=[0,0,1,-1,0,0]
dy=[1,-1,0,0,0,0]
dz=[0,0,0,0,1,-1]
queue=deque()

# 2. 익은 토마토 주변 다 익게 만들어
def BFS():
    while queue:
        z,x,y=queue.popleft()
        for i in range(6):
            nx,ny,nz=x+dx[i],y+dy[i],z+dz[i]
            if 0<=nx<n and 0<=ny<m and 0<=nz<h and tomato[nz][nx][ny]==0:
                # tabulation 방식으로 저장하면 visited 배열이 따로 필요X
                # 저장된 값 중 최댓값이 결국 횟수니까
                tomato[nz][nx][ny]=tomato[z][x][y]+1
                queue.append((nz,nx,ny))


# 1. 토마토가 익은 지점 탐색
# 탐색은 입력의 반대순
for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato[i][j][k]==1:
                queue.append((i,j,k))
BFS()

# 3. 예외처리
# 만약 한 곳에서라도 값이 0이 나오면 -1
# 만약 day =0 이라면 0
# 만약 day >0  이라면 day
cant=False
day=0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato[i][j][k]==0:
                cant=True
            else:
                day=max(day,tomato[i][j][k])

if cant:
    print(-1)
else:
    print(day-1)                   