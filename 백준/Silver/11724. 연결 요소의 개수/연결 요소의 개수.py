import sys
input=sys.stdin.readline
sys.setrecursionlimit(10000)

n,m=map(int, input().split())
graph=list([0]*(n+1) for _ in range(n+1))

for i in range(m):
    a,b=map(int, input().split())
    graph[a][b]=1
    graph[b][a]=1

def DFS(graph, v, visited):
    visited[v]=1 # 방문 체크
    for i in range(1,n+1):
        if visited[i]==0 and graph[v][i]==1:
            DFS(graph, i, visited)

visited=[0]*(n+1) # 간선이 아니라 점 기준 방문체크
cnt=0
for i in range(1, n+1):
    if visited[i]==0:
        DFS(graph, i, visited)
        cnt+=1
print(cnt)