# participant에는 있고 completion에는 없는 한 명을 찾자.

# key: hashing 한 값
# value: 각 선수의 이름

def solution(participant, completion):
    hashDict={}
    hashSum=0
    
    for p in participant:
        # 1. Hash: particiapant의 dictionary 만들기
        hashDict[hash(p)]=p
        # 2. Participant의 sum 구하기
        hashSum += hash(p)
        
    # 3. completion에 있는 p의 hash 값 빼기
    for c in completion:
        hashSum -= hash(c)
        
    # 4. 남은 hash 값 value가 완주 실패자
    return hashDict[hashSum]
    