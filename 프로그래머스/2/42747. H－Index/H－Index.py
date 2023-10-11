def solution(citations):
    # 피인용수를 내림차순 정렬
    answer = citations.sort(reverse=True)
    
    # idx는 논문 id
    for idx, citation in enumerate(citations):
        # 피인용수가 점점 줄어들다 해당 논문 번호와 같아지기 시작하면
        if citation <= idx:
            # H 지수는 해당 논문 번호와 같다.
            return idx
    # 그게 아니라면 전체 논문 수와 같다.
    return len(citations)
    