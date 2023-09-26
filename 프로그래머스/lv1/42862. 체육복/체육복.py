# def solution(n, lost, reserve):
    
#     # 여벌을 가져왔는데 도난 당한 학생 reserve, lost -> 바로 answer로 넣고 reserve에서 지워야해
#     # 여벌을 가져왔는데 도난 안 당한 학생 reserve -> 바로 answer, 근데 for문에서 lost한테 빌려줘야해
#     # 여벌을 안 가져왔는데 도난 당한 학생 lost -> for문을 돌려서 해당하면 answer
#     # 여벌을 안 가져왔는데 도난 안 당한 학생  -> 바로 answer
    
#     reserve.sort()
#     reserve=list(set(reserve))
#     lost.sort()
#     lost=list(set(lost))
    
#     # 수업을 들을 수 있는 학생 수 answer
#     answer = 0
#     answer += n-len(lost)
    
#     # 남은 여벌 체육복을 가지고 for문에서 처리
#     # lost가 체육복을 얻음과 동시에 reserve에서 빌려준 학생은 삭제
#     for i in lost: 
#         if i in reserve:
#             reserve.remove(i)
#             answer+=1
#         # lost에만 있는 학생이고, 앞번호한테 빌리겠다
#         if i-1 in reserve:
#             reserve.remove(i-1)
#             answer+=1
#         # lost에만 있는 학생이고, 뒷번호한테 빌리겠다
#         elif i+1 in reserve:
#             reserve.remove(i+1)
#             answer+=1
#     return answer

def solution(n, lost, reserve):
    used = set()
    reserve = set(reserve)
    lost.sort()
    for l in lost:
        if l in reserve:
            used.add(l)
        elif (l-1 in reserve) and (l-1 not in used):
            used.add(l-1)
        elif (l+1 in reserve) and (l+1 not in used):
            used.add(l+1)
            
    return n - len(lost) + len(used)