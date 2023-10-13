def solution(clothes):
    # 1. 종류 별 선택지 개수를 해싱
    # get(type,0) 해당 type에 개수가 없으면 0 출력
    # 한 type 안에 선택지가 n개면 해당 type별 경우의 수는 (n+1)개.
    # 해당 type에서 아무것도 선택 안할 수도 있으니까
    # 한 type안에 선택지가 없으면 선택지는 무조건 1개
    hash_map={}
    for clothe, type in clothes:
        hash_map[type] = hash_map.get(type,0) +1
        
        
    # 2. 입지 않는 경우를 포함해 계산
    answer = 1
    for type in hash_map:
        answer *= (hash_map[type]+1)
        
    # 3. 아무 것도 안 입는 경우 제외
    return answer-1
    
    return answer