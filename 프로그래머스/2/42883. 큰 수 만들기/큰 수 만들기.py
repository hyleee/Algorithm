def solution(number, k):
    answer=[] # stack
    
    for num in number:
        # num > answer[-1] 을 가장 마지막에 쓰는거 잊지말기
        while answer and k>0 and num > answer[-1]:
            answer.pop()
            k-=1
        answer.append(num)
    
    return ''.join(answer[:len(answer)-k])