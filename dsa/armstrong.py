a=int(input("enter a number: "))
oldnum=a
def counting(num):
    r=0
    while num>0:
        num=num//10
        r+=1
    return r
len=counting(a)
newnum=0
while a>0:
    newnum+=(a%10)**len
    a=a//10
if(oldnum==newnum):
    print("armstrong")
else:
    print("not an armstrong")
