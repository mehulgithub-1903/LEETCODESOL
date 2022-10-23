class Solution(object):
    def countBits(self, n):
        ans=[0]*(n+1)
        
        ans[0]=0
        if n==0:return ans
        ans[1]=1
        if n==1:return ans
        ans[2]=1
        if n==2:return ans
        
        for i in range(3,n+1):
            if i%2==0:
                ans[i]=ans[i//2]
            else:
                ans[i]=ans[i-1]+1
            
        return ans
        """
        :type n: int
        :rtype: List[int]
        """
        