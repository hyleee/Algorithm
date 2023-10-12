def solution(s):
    
    stack=[]
    
    for i in s:
        if i=="(": 
            stack.append(i)
        elif i==")":
            if stack: stack.pop()
            else: return False
    if stack: return False
    return True
    
    
    return True