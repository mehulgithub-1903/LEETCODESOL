class Solution(object):
    def nextGreaterElement(self, n):

        arr=[]
        while n>0:
            arr.insert(0,n%10)
            n=n//10
        n=len(arr)
        # print(arr)
        index=-1
        for i in range(n-1,0,-1):
            if arr[i-1]<arr[i]:
                index=i-1
                break
        if(index==-1) :return -1
        for i in range(n-1,index,-1):
            if arr[i]>arr[index]:
                arr[i],arr[index]=arr[index],arr[i]
                break
        # print(arr)
        l=index+1
        r=n-1
        while l<r:
            arr[l],arr[r]=arr[r],arr[l]
            l+=1
            r-=1
        # print(arr)
        res=arr[0]
        for i in range(1,n):
            res=res*10+arr[i]
        # print(res)
        # print(2**31-1)
        if(int(res)>=(2**31)): return -1
        return res
        """
        :type n: int
        :rtype: int
        """
        