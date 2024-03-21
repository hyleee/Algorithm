h,w = map(int, input().split())
world = list(map(int, input().split()))
water =0

for i in range(1, w-1):
    left = max(world[:i])
    right = max(world[i+1:])

    compare = min(left,right)
    
    if world[i] <compare:
        water += compare - world[i]

print(water)