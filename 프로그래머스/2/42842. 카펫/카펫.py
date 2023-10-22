def solution(brown, yellow):
    
    answer=[]
    total= brown+yellow
    
    for i in range(1, yellow+1):
        if yellow % i ==0:
            yellow_x = yellow // i
            yellow_y = i
        
        if brown == (yellow_x*2 + yellow_y*2 +4):
            answer.extend([yellow_x+2,yellow_y+2])
            break
    answer = sorted(answer, reverse=True)
    return answer




# yellow = (w-2)*(h-2)
# brown+yellow = w*h
        
# y 
# = 2*12  -> b = 2(위아래)*12 + 2(줄수)*2(양옆) + 4(구석)
# = 3*8   -> b = 2(위아래)*8 + 3(줄수)*2(양옆) + 4(구석)
# = 4*6   -> b= 2*6 + 4*2 + 4 = 12+8+4= 24

# 1. y를 자연수의 곱으로 분해
# 2. y=a*b 일때 a*2 + b*2 + 4 가 brown의 개수와 동일한 게 있을 것.
# 3. 이때 yellow=6*4 (가로가 더 기니까 더 큰수가 앞에)일때 (6+2)*(4+2)가 return 됨!

