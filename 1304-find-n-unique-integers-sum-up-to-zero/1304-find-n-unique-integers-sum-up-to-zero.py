class Solution(object):
    def sumZero(self, n):
        
        ans=[]
        for i in range(-1*(n//2),n//2 + 1):
            if(i==0):
               if n%2!=0:ans.append(i)
               else :continue
            else:
                ans.append(i)
        return ans
                
        """
        :type n: int
        :rtype: List[int]
        """
        