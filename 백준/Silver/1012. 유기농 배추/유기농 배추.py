t=int(input())

dx = [-1,0,1,0]
dy = [0,1,0,-1]


def BFS(x,y):
    queue =[(x,y)]
    arr[x][y]=0 # 방문 처리

    while queue:
        x, y = queue.pop(0) # 맨 처음 쌍 꺼내기
        for i in range(4):
            nx= x+dx[i]
            ny= y+dy[i]
            if nx<0 or nx>=m or ny<0 or ny>=n:
                continue
            if arr[nx][ny]==1:
                queue.append((nx,ny))
                arr[nx][ny]=0


for _ in range(t):
    m, n, k = map(int, input().split())
    arr = [[0]*n for _ in range(m)]
    cnt=0

    for _ in range(k):
        x, y = map(int, input().split())
        arr[x][y]=1

    for i in range(m):
        for j in range(n):
            if arr[i][j] ==1:
                BFS(i,j)
                cnt+=1 # BFS 한번 돌 때마다 cnt 1씩 증가

    print(cnt)