from collections import defaultdict

def solution(tickets):
    
    tour_dict = defaultdict(list)
    
    for start, end in tickets:
        tour_dict[start].append(end)
    
    for tour_key in tour_dict.keys():
        tour_dict[tour_key].sort(reverse=True)
        
    answer=[]
    path=["ICN"]
    
    
    while path:
        # path에 가장 최근에 추가된 장소를 기준으로 생각 
        now=path[-1]
        
        # 애초에 출발지 키가 없거나, 출발지 키에 해당하는 도착지가 tour_dict에 없는 경우
        # 여행이 끝난 것으로 간주
        if now not in tour_dict or len(tour_dict[now])==0 :
            answer.append(path.pop())
        else:
        # 여행이 끝나지 않았으므로 path를 계속 늘리기
            path.append(tour_dict[now].pop())
            
    return answer[::-1]
        
    