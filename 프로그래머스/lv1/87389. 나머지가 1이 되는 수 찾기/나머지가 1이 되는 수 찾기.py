def solution(n):
    for x in range(1,n+1):
        if n%x==1:
            answer=x
            break
    return answer