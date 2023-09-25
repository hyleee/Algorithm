# print(str.swapcase())
answer=""
for i in input():
    if i.islower():
        answer += i.upper()
    else:
        answer += i.lower()
print(answer)
