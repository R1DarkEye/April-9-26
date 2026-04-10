import math
a=int(input("enter a number to find factors: "))
factors=[]
#way 1
def fac( num):
    for i in range(1,num+1):
        if(num%i==0):
            factors.append(i)

#way 2
def fac2( num):
    for i in range(1,num//2+1):
        if(num%i==0):
            factors.append(i)
    factors.append(num)
#way 3
def fac3( num):
    for i in range(1,int((math.sqrt(num))+1)):
        if(num%i==0):
            factors.append(int(i))
            if(num/i != i):
                factors.append(int(num/i))

fac(a)#time complexicity=O(n) space complexicity O(k) where k is the number of factors
print(factors)
factors.clear()
fac2(a)#time complexicity=O(n/2) space complexicity O(k) where k is the number of factors
print(factors)
factors.clear()
fac3(a)#time complexicity=O(sqrt(n)) space complexicity O(k) where k is the number of factors
print(factors)

    
    
