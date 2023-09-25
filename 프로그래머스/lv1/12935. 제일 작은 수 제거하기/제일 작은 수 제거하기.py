def solution(arr):
    if  len(arr)>=2:
        arr.remove(min(arr))
    else:
        arr.clear()
        arr=[-1]
    return arr