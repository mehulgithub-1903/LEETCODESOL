class Solution(object):
    def singleNumber(self, nums):
        
        ans=0
        for x in nums:
            ans=ans^x
        return ans
                
        """
        :type nums: List[int]
        :rtype: int
        """
        