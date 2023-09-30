def solution(order):
    answer=0
    for menu in order:
        if 'americano' in menu:
            answer+=4500
        elif 'cafelatte' in menu:
            answer+=5000
        else:
            answer+=4500
    return answer

    
    
    return answer