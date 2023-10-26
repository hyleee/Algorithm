# stack BFS
# def solution(n, computers):
    
#     visited = [False for _ in range(n)]
#     answer = 0
    
#     for com in range(n):
#         if visited[com]==False:
#             BFS(n,computers,com,visited)
#             answer+=1 # DFS로 컴퓨터를 최대한 방문하게 만들고 빠져나오면 그것이 네트워크
#     return answer

# # 길이, input배열, 인덱스, 방문여부확인용 배열
# def BFS(n,computers, com, visited):
#     visited[com] = True
#     for connect in range(n):
#         if connect!=com and computers[com][connect] ==1: # 연결된 컴퓨터
#             if visited[connect] == False:
#                 BFS(n, computers, connect, visited)

from collections import deque
def solution(n, computers):
    answer =0
    visited =[False for i in range(n)]
    for com in range(n):
        if visited[com]==False:
            BFS(n, computers, com, visited)
            answer+=1
    return answer

def BFS(n,computers,com,visited):
    visited[com]=True
    queue=[]
    # 현재 내가 방문한 컴퓨터의 인덱스를 삽입해서 타고타고.....
    queue.append(com)
    while len(queue)!=0:
        com= queue.pop(0)
        visited[com]=True
        for connect in range(n):
            # 네트워크 상 연결되어있는데 아직 방문하지 않았다면 방문하도록
            if connect!=com and computers[com][connect] ==1:
                if visited[connect]==False:
                    queue.append(connect)
                