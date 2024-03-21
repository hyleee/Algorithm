import sys
input = sys.stdin.readline

n,r,c=map(int, input().split()) 

answer=0

while n!=0:
    n-=1

    if r<2**(n) and c<2**(n): # 1사분면
        answer+= (2**(n))*(2**(n))*0
    elif r<2**(n) and c>=2**(n): # 2사분면
        c-=2**(n)
        answer+= (2**(n))*(2**(n))*1
    elif r>=2**(n) and c<2**(n): # 3사분면 
        answer+= (2**(n))*(2**(n))*2
        r-=2**(n)
    elif r>=2**(n) and c>=2**(n): # 4사분면
        answer+= (2**(n))*(2**(n))*3
        r-=2**(n)
        c-=2**(n)
        
print(answer)



# # sol2
# def sol(N, r, c):

# 	if N == 0:
# 		return 0
        
# 	return 2*(r%2)+(c%2) + 4*sol(N-1, int(r/2), int(c/2))

# n=3일때
# 1사분면: 0 = 2^(n) * 2^(n) - 2^(n+4)
  # 2^2 * 2^2
  # n=2 
  # 1-1사분면: 0 2^2 * 2^2 - 
  # 1-2사분면: 4 2^2 * 2^2 - 3/4*2^2*2^2
  # 1-3사분면: 8 
  # 1-4사분면: 12

# 2사분면: 16 = 2^(n) * 2^(n) - 3/4*2^(n)*2^(n)
    # 2-1사분면: 16 2^2 * 2^2 - 2^2*2^2
# 3사분면: 32 = 2^(n) * 2^(n) - 2/4
# 4사분면: 48 = 2^(n) * 2^(n) * 1/4
