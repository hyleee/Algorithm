def solution(numbers):
    numbers= list(map(str,numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)
    # sort(key=) 의 기본 값은 오름차순이라서. 내림차순으로 바꾸기 위해 reverse
    answer = str(int(''.join(numbers)))
    return answer