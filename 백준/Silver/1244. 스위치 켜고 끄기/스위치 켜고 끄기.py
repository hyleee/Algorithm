import sys
input = sys.stdin.readline


def change(num):
    if arr[num]==1:
      arr[num]=0
    elif arr[num]==0:
      arr[num]=1
    return


n =int(input())
arr = [-1]+list(map(int, input().split())) #
m = int(input())

for _ in range(m):
   s, num=map(int, input().split())
   if s==1:
        for i in range(num, n+1, num):
            change(i)
   else:
        change(num) #
        for k in range(1, n//2):
            if num+k>n or num-k<1:
                break
            if arr[num-k]==arr[num+k]:
                change(num-k)
                change(num+k)
            else: break

for i in range(1, n+1):
    print(arr[i], end=' ')
    if i%20==0:
         print()





         
      
      