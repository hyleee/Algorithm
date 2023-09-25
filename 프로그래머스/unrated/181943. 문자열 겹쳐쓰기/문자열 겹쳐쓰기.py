def solution(my_string, overwrite_string, s):
    answer = ''
    index = len(overwrite_string)
    answer+=my_string[0:s]
    answer+=overwrite_string
    answer+=my_string[s+index:]
    return answer