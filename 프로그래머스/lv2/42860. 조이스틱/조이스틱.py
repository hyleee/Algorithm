def solution(name):
    name=list(name)
    answer=0
    
    # 자릿수를 이동하기 위한 최소 이동 횟수
    min_move=len(name)-1
    
    for (i,char) in enumerate(name):
        # 해당 알파벳 최소 변경
        answer += min(ord(char)-ord('A'), ord('Z')-ord(char)+1)
        
        # 해당 알파벳 다음 알파벳부터 연속된 A 문자열 찾기. 
        # 가장 오른쪽 A의 index를 next에 저장
        next=i+1
        while next<len(name) and name[next]=='A':
            next+=1
        # BBABBB
        min_move=min([min_move, i+i+len(name)-next, 2*(len(name)-next)+i] )
    answer+=min_move
    return answer