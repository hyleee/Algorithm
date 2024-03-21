s = int(input())
num=0
total=0

while True:
    num += 1
    total += num
    if total > s:
        break

print(num-1)