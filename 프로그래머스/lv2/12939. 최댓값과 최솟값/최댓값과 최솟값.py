def solution(s):
    numbers=list(map(int,s.split()))
    numbers.sort()
    
    return str(numbers[0])+" "+str(numbers[-1])