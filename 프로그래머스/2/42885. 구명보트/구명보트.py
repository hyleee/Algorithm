# 보트를 가장 적은 횟수로 사람들을 이동시키려면 
# 제일 무거운 사람, 제일 가벼운 사람을 같이 묶어서 처리해야한다는 게 핵심
from collections import deque

def solution(people, limit):
    
    queue= deque(sorted(people,reverse=True)) # 내림차순
    answer=0
    
    while len(queue)>1:
        if queue[0] + queue[-1] <= limit:
            queue.pop()
            queue.popleft()
            answer+=1
        else: 
            queue.popleft()
            answer+=1
    if queue:
        answer+=1
        
    return answer