from collections import deque
import sys
input = sys.stdin.readline

m, n = map(int, input().split())
# tomato = [list(map(int,input().split())) for _ in range(n)]
# print(tomato)
tomato=[]
for _ in range(n):
    tomato.append(list(map(int, input().split())))

queue = deque()
for i in range(n):
    for j in range(m):
        if tomato[i][j] == 1:
            queue.append([i, j])

def bfs():
    while queue:
        x, y = queue.popleft()
        dx = [-1,1,0,0]
        dy = [0,0,-1,1]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and tomato[nx][ny]==0:
                tomato[nx][ny] = tomato[x][y] + 1
                queue.append((nx, ny))

bfs()

day = 0
for row in tomato:
    for i in row:
        if i==0:
            print(-1)
            exit()
    else:
        day=max(day,max(row))

print(day-1)
