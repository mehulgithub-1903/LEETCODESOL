# 01001101
class Solution(object):
    def goodDaysToRobBank(self, arr, time):
        ans=[]
        n=len(arr)

        # Longest NonIncreasing Subarray Ending At index

        pdec=[0]*n 
        
        # Longest NonDecreasing Subarray Starting from index 
        ninc=[0]*n
        
        pdec[0]=1
        for i in range(1,n):
            pdec[i] = 1 if arr[i]>arr[i-1] else pdec[i-1]+1
        
        ninc[n-1]=1
        for i in range(n-2,-1,-1):
            ninc[i] = 1 if arr[i]>arr[i+1] else ninc[i+1]+1
        for i in range(n):
            if i-time>=0 and i+time<=n-1:
                if (pdec[i]-1 )>=time and (ninc[i]-1)>=time:
                    ans.append(i)
        
        return ans

        """
        :type security: List[int]
        :type time: int
        :rtype: List[int]
        """