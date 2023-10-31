from collections import deque
import sys
input = sys.stdin.readline

n,m,v=map(int, input().split())
grapgh=[[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a,b=map(int, input().split())
    grapgh[a][b]=1
    grapgh[b][a]=1


# 간선이 아니라 점으로 방문기록
visit1=[0]*(n+1) # DFS 방문기록
visit2=[0]*(n+1)  # BFS 방문기록

def DFS(arr,v):
    visit1[v]=1
    print(v, end=' ')
    for i in range(1, n+1):
        if arr[v][i]==1 and visit1[i]==0:
            visit1[i]=1
            DFS(arr,i)
            
def BFS(arr,v):
    visit2[v]=1
    queue=deque()
    queue.append(v)
    while queue:
        v=queue.popleft()
        print(v, end=' ')
        for i in range(1, n+1):
            if grapgh[v][i]==1 and visit2[i]==0:
                visit2[i]=1
                queue.append(i)
    

DFS(grapgh, v)
print()
BFS(grapgh, v)