a=int(input("Enter a string: "))
b=0
while a>0:
    r=a%10
    b=b*10+r
    a=a//10
print(b)